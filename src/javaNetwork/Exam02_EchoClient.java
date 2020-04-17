package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam02_EchoClient extends Application {
	private TextArea ta;
	private TextField input;
	private Button conBtn;
	private Socket s;
	private BufferedReader br;
	private PrintWriter pr;

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

		conBtn = new Button("서버 연결하기");
		conBtn.setPrefSize(250, 50);
		conBtn.setOnAction(e -> {
			try {
				// 연결되면 TextArea의 내용을 지워요!
				ta.clear();

				s = new Socket("localhost", 7979);
//				String address = s.getInetAddress().toString();
//				System.out.println(address);
				printMSG("서버 접속 성공!");
				printMSG("접속을 종료하시려면 @EXIT 를 입력하세요.");
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				pr = new PrintWriter(s.getOutputStream());

				// 접속 성공 했으니 입력상자 활성화!
				input.setDisable(false);
				conBtn.setDisable(true);
				Thread thread = new Thread(new Runnable() {

					@Override
					public void run() {
						String revString = "";
						try {
							while ((revString = br.readLine()) != null) {
								printMSG(revString);
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});
				thread.start();
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		input = new TextField();
		input.setPrefSize(400, 50);
		input.setDisable(true);
		// 입력상자에서 글을 입력하고 enter 를 치면 Action이 발생함.
		input.setOnAction(e -> {
			String msg = input.getText();
			pr.println(msg);
			pr.flush();
			input.clear();

			if (!msg.equals("@EXIT")) {
//				try {
//					String revString = br.readLine();
//					printMSG(revString);
//				} catch (IOException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}

			} else {
				printMSG("[서버와의 연결종료]");
				input.setDisable(true);
				conBtn.setDisable(false);
				try {
					br.close();
					pr.close();
					s.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(input);
		flowpane.getChildren().add(conBtn);

		root.setBottom(flowpane);

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("예제용 JavaFX");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		// 현재 사용되는 Thread 의 이름을 출력할꺼에요!
		launch();

	}

}
