package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exam05_MultiRoomChatClient extends Application {

	private TextArea chatArea; // 채팅창역활을 하는 TextArea
	private Button connBtn; // 채팅서버와 연결을 하기 위한 버튼
	private Button disconnBtn; // 채팅서버와 연결을 종료하기 위한 버튼
	private Button createRoomBtn; // 새로운 채팅방을 만드는 버튼
	private Button connRoomBtn; // 채팅방에 들어가는 버튼
	private Button disconnRoomBtn; // 채팅방에 나가는 버튼
	private FlowPane menuFlowPane;
	private static ListView<String> roomListView; // 채팅방 목록을 표시하는 리스트뷰
	private static ListView<String> participantsListView; // 채팅방에 참여하고 있는 사람 목록
	private User user;

	private ExecutorService excutorService;

	private void printMsg(String msg) {
		Platform.runLater(() -> {
			chatArea.appendText(msg + "\n");
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		BorderPane root = new BorderPane(); // 화면 동서남북중앙 다섯 영역으로 나눔
		root.setPrefSize(700, 500);

		chatArea = new TextArea();
		chatArea.setEditable(false);
		root.setCenter(chatArea);

		// 방목록
		roomListView = new ListView<String>();
		// 참여자 목록
		participantsListView = new ListView<String>();

		// 화면을 격자로 나누어서 component 를 쵸현하는 layout
		GridPane gridpane = new GridPane();
		// gridpane 의 paddding부터 설정
		gridpane.setPadding(new Insets(10, 10, 10, 10));

		gridpane.setVgap(10);
		gridpane.add(roomListView, 0, 0);
		gridpane.add(participantsListView, 0, 1);

		root.setRight(gridpane);

		connBtn = new Button("Chat 서버와 접속");
		connBtn.setPrefSize(150, 40);
		connBtn.setOnAction(e -> {
			excutorService = Executors.newCachedThreadPool();
			Dialog<String> dialog = new TextInputDialog("자신의 NickName을 입력하세요!");
			dialog.setTitle("닉네임설정");
			dialog.setHeaderText("닉네임 설정입니다. 적절한 이름을 입력하세요!");

			Optional<String> result = dialog.showAndWait();
			String entered = "";
			if (result.isPresent()) {
				// 닉네임을 입력하고 확인버튼을 누른경우!
				entered = result.get();
			}
			user = new User(entered, 5959);
			excutorService.execute(user);
			createRoomBtn.setDisable(false);
			connRoomBtn.setDisable(false);
			disconnBtn.setDisable(false);
			connBtn.setDisable(true);
		});

		createRoomBtn = new Button("채팅방 생성");
		createRoomBtn.setPrefSize(150, 40);
		createRoomBtn.setDisable(true);
		createRoomBtn.setOnAction(e -> {
			Dialog<String> dialog = new TextInputDialog("생성할 방 이름을 입력하세요!");
			dialog.setTitle("채팅방 설정");
			dialog.setHeaderText("채팅방 설정입니다. 적절한 이름을 입력하세요!");

			Optional<String> result = dialog.showAndWait();
			String entered = "";
			if (result.isPresent()) {
				entered = result.get();
			}

			user.createRoom(entered);
			printMsg("채팅방 : " + entered + "가 추가되었습니다.");

		});

		connRoomBtn = new Button("채팅방 접속!");
		connRoomBtn.setDisable(true);
		connRoomBtn.setPrefSize(150, 40);
		connRoomBtn.setOnAction(e -> {
			// 1. 어떤 방을 선택했는지를 알아와요!
			String roomName = roomListView.getSelectionModel().getSelectedItem();
			user.joinRoom(roomName);
			printMsg(roomName + "방에 입장하였습니다!");

			// 서버에 접속해서 현재 방에 참여하고 있는 참여자 목록을 받아와요!
			// 목록을 받아오면 참여자 리스트뷰에 출력

			// 밑부분의 메뉴를 채팅을 입력할 수 있는 화면으로 전환!
			FlowPane inputFlowPane = new FlowPane();
			inputFlowPane.setPadding(new Insets(10, 10, 10, 10));
			inputFlowPane.setPrefSize(700, 40);
			inputFlowPane.setHgap(10);

			TextField inputTF = new TextField();
			inputTF.setPrefSize(400, 40);
			inputTF.setOnAction(e3 -> {
				user.sendMsg(inputTF.getText());
				inputTF.clear();
			});

			disconnRoomBtn = new Button("방 나가기");
			disconnRoomBtn.setPrefSize(150, 40);
			disconnRoomBtn.setOnAction(e2 -> {
				user.outRoom();
				participantsListView.getItems().clear();
				root.setBottom(menuFlowPane);
			});
			inputFlowPane.getChildren().add(inputTF);
			inputFlowPane.getChildren().add(disconnRoomBtn);
			root.setBottom(inputFlowPane);
		});

		disconnBtn = new Button("채팅 서버와 연결 끊기");
		disconnBtn.setPrefSize(150, 40);
		disconnBtn.setDisable(true);
		disconnBtn.setOnAction(e4 -> {
			roomListView.getItems().clear();
			user.disconnServer();
			createRoomBtn.setDisable(true);
			connRoomBtn.setDisable(true);
			connBtn.setDisable(false);
			disconnBtn.setDisable(true);
		});

		menuFlowPane = new FlowPane();
		menuFlowPane.setPadding(new Insets(10, 10, 10, 10));
		menuFlowPane.setPrefSize(700, 40);
		menuFlowPane.setHgap(10);
		menuFlowPane.getChildren().add(connBtn);
		menuFlowPane.getChildren().add(createRoomBtn);
		menuFlowPane.getChildren().add(connRoomBtn);
		menuFlowPane.getChildren().add(disconnBtn);

		root.setBottom(menuFlowPane);

		// 창을 띄우기 위한 코드

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("멀티룸 채팅프로그램");
		primaryStage.setOnCloseRequest(e -> {
//			user.disconnServer();
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

	public static void reRoomList(String[] rooms) {
		Platform.runLater(() -> {
			roomListView.getItems().clear();
			for (String room : rooms) {
				roomListView.getItems().add(room);
			}
		});
	}

	public static void reMemberList(String[] members) {
		Platform.runLater(() -> {
			participantsListView.getItems().clear();
			for (String memeber : members) {
				participantsListView.getItems().add(memeber);
			}
		});
	}

	class User implements Runnable {
		private String userId;
		private Socket s;
		private BufferedReader br;
		private PrintWriter pw;

		public User(String id, int port) {
			this.userId = id;
			try {
				s = new Socket("localhost", 5959);
				this.br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				this.pw = new PrintWriter(s.getOutputStream());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void connServer() {
			pw.println(ChatHelper.P_CONNECT + userId);
			printMsg(userId + "로 서버에 접속하였습니다.");
			pw.flush();
		}

		public void disconnServer() {
			pw.println(ChatHelper.P_DISCONNECT + userId);
			pw.flush();
		}

		public void joinRoom(String roomName) {
			pw.println(ChatHelper.P_JOIN + roomName);
			pw.flush();
		}

		public void createRoom(String roomName) {
			pw.println(ChatHelper.P_CREATE + roomName);
			pw.flush();
		}

		public void sendMsg(String msg) {
			pw.println(msg);
			pw.flush();
		}

		public void outRoom() {
			pw.println(ChatHelper.P_OUT + userId);
			pw.flush();
		}

		@Override
		public void run() {
			connServer();
			String revString = "";
			try {
				while ((revString = br.readLine()) != null) {
					if (revString.startsWith(ChatHelper.P_CONNECT)) {
						String[] roomStr = revString.substring(ChatHelper.P_CONNECT_LEN).split(ChatHelper.DIV_R);
						reRoomList(roomStr);
					} else if (revString.startsWith(ChatHelper.P_ROOM)) {
						String[] roomStr = revString.substring(ChatHelper.P_ROOM_LEN).split(ChatHelper.DIV_R);
						reRoomList(roomStr);
					} else if (revString.startsWith(ChatHelper.P_JOIN)) {
						String[] r_memberStr = revString.substring(ChatHelper.P_JOIN_LEN).split(ChatHelper.DIV_R);
						reMemberList(r_memberStr);
					} else if (revString.startsWith(ChatHelper.P_DISCONNECT)) {
						break;
					} else {
						printMsg(revString);
					}
				}
				if (br != null)
					br.close();
				if (pw != null)
					pw.close();
				if (s != null)
					s.close();
				if (excutorService != null)
					excutorService.shutdown();
			} catch (IOException e) {
				System.out.println("비정상 적인 종료가 발견되었습니다.");
				try {

					if (br != null)
						br.close();
					if (pw != null)
						pw.close();
					if (s != null)
						s.close();
					if (excutorService != null)
						excutorService.shutdown();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}

}
