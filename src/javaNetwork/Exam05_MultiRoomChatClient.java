package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
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
	private static ListView<String> roomListView; // 채팅방 목록을 표시하는 리스트뷰
	private static ListView<String> participantsListView; // 채팅방에 참여하고 있는 사람 목록
	private User user;

	private ExecutorService excutorService = Executors.newCachedThreadPool();

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
			Dialog<String> dialog = new TextInputDialog("자신의 NickName을 입력하세요!");
			dialog.setTitle("닉네임설정");
			dialog.setHeaderText("닉네임 설정입니다. 적절한 이름을 입력하세요!");

			Optional<String> result = dialog.showAndWait();
			String entered = "";
			if (result.isPresent()) {
				// 닉네임을 입력하고 확인버튼을 누른경우!
				entered = result.get();
			}
			// 원래는 서버에 접속해서 방 목록을 받아와야 해요!
			user = new User(entered, 5959);
			excutorService.execute(user);
			createRoomBtn.setDisable(false);
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
				// 닉네임을 입력하고 확인버튼을 누른경우!
				entered = result.get();
			}

			// 방이름이 서버에 전달이 되어야해요!

			roomListView.getItems().add(entered);
			printMsg("채팅방 : " + entered + "가 추가되었습니다.");

		});

		connRoomBtn = new Button("채팅방 접속!");
		connRoomBtn.setPrefSize(150, 40);
		connRoomBtn.setOnAction(e -> {
			// 1. 어떤 ㅂ아을 선택했는지를 알아와요!
			String roomName = roomListView.getSelectionModel().getSelectedItem();
			printMsg(roomName + "방에 입장하였습니다!");

			// 서버에 접속해서 현재 방에 참여하고 있는 참여자 목록을 받아와요!
			// 목록을 받아오면 참여자 리스트뷰에 출력
			participantsListView.getItems().add("홍길동");
			participantsListView.getItems().add("신사임당");
			participantsListView.getItems().add("이순신");
			participantsListView.getItems().add("김찬호");

			// 밑부분의 메뉴를 채팅을 입력할 수 있는 화면으로 전환!
			FlowPane inputFlowPane = new FlowPane();
			inputFlowPane.setPadding(new Insets(10, 10, 10, 10));
			inputFlowPane.setPrefSize(700, 40);
			inputFlowPane.setHgap(10);

			TextField inputTF = new TextField();
			inputTF.setPrefSize(400, 40);

			inputFlowPane.getChildren().add(inputTF);

			root.setBottom(inputFlowPane);
		});

		FlowPane menuFlowPane = new FlowPane();
		menuFlowPane.setPadding(new Insets(10, 10, 10, 10));
		menuFlowPane.setPrefSize(700, 40);
		menuFlowPane.setHgap(10);
		menuFlowPane.getChildren().add(connBtn);
		menuFlowPane.getChildren().add(createRoomBtn);
		menuFlowPane.getChildren().add(connRoomBtn);

		root.setBottom(menuFlowPane);

		// 창을 띄우기 위한 코드

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("멀티룸 채팅프로그램");
		primaryStage.setOnCloseRequest(e -> {

		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
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
			try {
				printMsg(userId + "로 서버에 접속하였습니다.");
				pw.println("/connect");
				pw.flush();
				String[] roomStr = br.readLine().split(" ");
				for (String room : roomStr) {
					roomListView.getItems().add(room);
				}
				printMsg(userId + "방 목록을 받아왔습니다.");
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		public void joinRoom(String roomName) {
			participantsListView.getItems().clear();
			pw.println("/join " + roomName);
			pw.flush();
			String[] roomMember;
			try {
				roomMember = br.readLine().split(" ");
				for (String member : roomMember) {
					participantsListView.getItems().add(member);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void createRoom(String roomName) {
			participantsListView.getItems().clear();
			pw.println("/create " + roomName);
			pw.flush();
			String[] roomMember;
			try {
				roomMember = br.readLine().split(" ");
				for (String member : roomMember) {
					participantsListView.getItems().add(member);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			connServer();
		}

	}

}
