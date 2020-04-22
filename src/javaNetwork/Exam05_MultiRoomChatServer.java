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

	private ExecutorService excutorService;
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
				excutorService = Executors.newCachedThreadPool();
				Runnable serverRunnable = () -> {
					printMSG("서버를 시작합니다!");
					while (true) {
						try {
							Socket s = server.accept();
							System.out.println("클라이언트가 들어왔습니다.");
							ChatRunnable runnable = new ChatRunnable(s);
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

	class ChatRoomManageObject {
		private List<ChatRunnable> list_chatRunnable = new ArrayList<ChatRunnable>();
		private Map<String, List<ChatRunnable>> map_chatRunnable = new HashMap<String, List<ChatRunnable>>();
		private List<String> r_name = new ArrayList<String>();

		public void connServer(ChatRunnable user) {
			list_chatRunnable.add(user);
		}

		public void disconnServer(ChatRunnable user) {
			list_chatRunnable.remove(user);
			user.getPw().println(ChatHelper.P_DISCONNECT);
			user.getPw().flush();
		}

		public void createRoom(String room, ChatRunnable user) {
			map_chatRunnable.put(room, new ArrayList<ChatRunnable>());
			r_name.add(room);
		}

		public void joinRoom(String room, ChatRunnable user) {
			map_chatRunnable.get(room).add(user);
		}

		public void outRoom(ChatRunnable user) {
			if (user.getUserRoom() != null) {
				map_chatRunnable.get(user.userRoom).remove(user);
				refreshMember(user);
			}
		}

		public void refreshRoom() {
			StringBuilder stb = new StringBuilder();
			stb.append(ChatHelper.P_ROOM);
			for (String str : getr_name()) {
				stb.append(str + ChatHelper.DIV_R);
			}
			for (ChatRunnable chatRunnable : list_chatRunnable) {
				chatRunnable.getPw().println(stb.toString());
				chatRunnable.getPw().flush();
			}
		}

		public void refreshMember(ChatRunnable user) {
			StringBuilder stb = new StringBuilder();
			stb.append(ChatHelper.P_JOIN);
			List<ChatRunnable> r_member = map_chatRunnable.get(user.getUserRoom());
			for (ChatRunnable member : r_member) {
				stb.append(member.getUserId() + ChatHelper.DIV_R);
			}
			for (ChatRunnable member : r_member) {
				member.getPw().println(stb.toString());
				member.getPw().flush();
			}
		}

		public void sendMsg(ChatRunnable user, String msg) {
			for (ChatRunnable ChatRunnable : map_chatRunnable.get(user.getUserRoom())) {
				PrintWriter pw = ChatRunnable.getPw();
				pw.println(user.getUserId() + ":" + msg);
				pw.flush();
			}
		}

		public Map<String, List<ChatRunnable>> getMap_chatRunnable() {
			return map_chatRunnable;
		}

		public void setMap_chatRunnable(Map<String, List<ChatRunnable>> map_chatRunnable) {
			this.map_chatRunnable = map_chatRunnable;
		}

		public List<String> getr_name() {
			return r_name;
		}

		public void setr_name(List<String> r_name) {
			this.r_name = r_name;
		}

	}

	class ChatRunnable implements Runnable {
		private Socket s;
		private BufferedReader br;
		private PrintWriter pw;
		private String userId;
		private String userRoom = null;

		public String getUserId() {
			return userId;
		}

		public String getUserRoom() {
			return userRoom;
		}

		public PrintWriter getPw() {
			return pw;
		}

		public ChatRunnable(Socket s) {
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
				while ((revString = br.readLine()) != null) {
					if (revString.startsWith(ChatHelper.P_JOIN)) {
						chatManager.outRoom(this);
						String roomTitle = revString.substring(ChatHelper.P_JOIN_LEN);
						userRoom = roomTitle;
						chatManager.joinRoom(roomTitle, this);
						chatManager.refreshMember(this);
					} else if (revString.startsWith(ChatHelper.P_CREATE)) {
						// 방만들기 요청이 들어왔을때 방을 생성
						// 방을 만들었을때 서버에 접속해있는 클라이언트 들에게 방목록을 보내줌.
						chatManager.outRoom(this);
						String roomTitle = revString.substring(ChatHelper.P_CREATE_LEN);
						userRoom = roomTitle;
						chatManager.createRoom(roomTitle, this);
						chatManager.refreshRoom();
					} else if (revString.startsWith(ChatHelper.P_CONNECT)) {
						// 접속했을때 방목록을 클라이언트에 보내줌
						userId = revString.substring(ChatHelper.P_CONNECT_LEN);
						chatManager.connServer(this);
						chatManager.refreshRoom();
					} else if (revString.startsWith(ChatHelper.P_OUT)) {
						userId = revString.substring(ChatHelper.P_OUT_LEN);
						chatManager.outRoom(this);
					} else if (revString.startsWith(ChatHelper.P_DISCONNECT)) {
						userId = revString.substring(ChatHelper.P_DISCONNECT_LEN);
						chatManager.outRoom(this);
						chatManager.disconnServer(this);
						break;
					} else {
						chatManager.sendMsg(this, revString);
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

	}
}
