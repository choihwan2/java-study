package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam05_MultiRoomChatServer extends Application {
	private TextArea ta;
	private Button onBtn, closeBtn;
	private ServerSocket server;

	// Thread Pool을 생성 제한된 숫자의 Thread를 가지고 있는 pool 이 아니라 필요한 갯수만큼 Thread 를 가지고 잇는
	// Thread Pool을 생성

	private ExecutorService excutorService = Executors.newCachedThreadPool();
	private ChatRoomManageObject chatManager = new ChatRoomManageObject();

	private void printMSG(String msg) {
		Platform.runLater(() -> {
			ta.appendText(msg + "\n");
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println(Thread.currentThread().getName());
		BorderPane root = new BorderPane();
		root.setPrefSize(700, 500);
		ta = new TextArea();
		root.setCenter(ta);

		onBtn = new Button("서버를 실행~!");
		onBtn.setPrefSize(250, 50);
		onBtn.setOnAction(e -> {
			try {
				server = new ServerSocket(5959);
				Runnable serverRunnable = () -> {
					printMSG("서버를 시작합니다!");
					while (true) {
						try {
							Socket s = server.accept();
							System.out.println("클라이언트가 들어왔습니다.");
							MyChatRunnable runnable = new MyChatRunnable(s);
							excutorService.execute(runnable);
						} catch (IOException e2) {
							break;
						}

					}
				};
				excutorService.execute(serverRunnable);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		closeBtn = new Button("서버를 종료합니다.");
		closeBtn.setPrefSize(250, 50);
		closeBtn.setOnAction(e -> {
			try {
				printMSG("서버를 종료합니다.");
				if (excutorService != null)
					excutorService.shutdown();
				if (server != null)
					server.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(onBtn);
		flowpane.getChildren().add(closeBtn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("채팅방 서버");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();

	}

	static class ChatRoomManageObject {
		private Map<String, List<MyChatRunnable>> map_chatRunnable = new HashMap<String, List<MyChatRunnable>>();
		private List<String> room_title = new ArrayList<String>();
		private Map<String, List<String>> room_member = new HashMap<String, List<String>>();
	
		public void createRoom(String room_t, MyChatRunnable user) {
			map_chatRunnable.put(room_t, new ArrayList<MyChatRunnable>());
			room_title.add(room_t);
			room_member.put(room_t, new ArrayList<String>());
		}

		public void joinRoom(String room_t, MyChatRunnable user) {
			map_chatRunnable.get(room_t).add(user);
			room_member.get(room_t).add(user.getUserId());
		}

		public void outRoom(String room_t, MyChatRunnable user) {
			map_chatRunnable.get(room_t).remove(user);
			room_member.get(room_t).remove(user.getUserId());
		}

		public void sendMsg(String room_t, String msg) {
			for (MyChatRunnable MyChatRunnable : map_chatRunnable.get(room_t)) {
				PrintWriter pw = MyChatRunnable.getPw();
				pw.println(msg);
				pw.flush();
			}
		}

		public Map<String, List<MyChatRunnable>> getMap_chatRunnable() {
			return map_chatRunnable;
		}

		public void setMap_chatRunnable(Map<String, List<MyChatRunnable>> map_chatRunnable) {
			this.map_chatRunnable = map_chatRunnable;
		}

		public Map<String, List<String>> getRoom_member() {
			return room_member;
		}

		public void setRoom_member(Map<String, List<String>> room_member) {
			this.room_member = room_member;
		}

		public List<String> getRoom_title() {
			return room_title;
		}

		public void setRoom_title(List<String> room_title) {
			this.room_title = room_title;
		}

	}

	class MyChatRunnable implements Runnable {
		private Socket s;
		private BufferedReader br;
		private PrintWriter pw;
		private String userId;

		public String getUserId() {
			return userId;
		}

		public MyChatRunnable(Socket s) {
			this.s = s;
			try {
				this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				this.pw = new PrintWriter(s.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				String revString = "";

				while (!Thread.currentThread().isInterrupted()) {
					revString = br.readLine();
					if (revString == null || revString.equals("@EXIT")) {
						break;
					} else if (revString.startsWith("/join")) {
						String roomTitle = revString.substring(6);
						chatManager.joinRoom(roomTitle, this);
						for (String member : chatManager.getRoom_member().get(roomTitle)) {
							pw.append(member + " ");
						}
						pw.println();
						pw.flush();
					} else if (revString.startsWith("/create")) {
						String roomTitle = revString.substring(6);
						chatManager.createRoom(roomTitle, this);
					} else if (revString.equals("/connect")) {
						for (String str : chatManager.getRoom_title()) {
							pw.print(str + " "); 
						}
						pw.println();
						pw.flush();
					} else {
					}
				}
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
				if (s != null)
					s.close();
				printMSG(userId + "님이 퇴장하셨습니다!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public PrintWriter getPw() {
			return pw;
		}

	}
}
