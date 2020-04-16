package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Selft_MultiEchoServer extends Application {
	private TextArea ta;
	private Button onBtn, closeBtn;
	Socket s;
	Thread serverThread;
	ServerSocket server;

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
				server = new ServerSocket(8989);
				serverThread = new Thread(() -> {
					printMSG("서버를 시작합니다!");
					while (true) {
						try {
							s = server.accept();
							MyEchoRunnalbe runnable = new MyEchoRunnalbe(s);
							Thread t = new Thread(runnable);
							t.setDaemon(true);
							t.start();
						} catch (IOException e2) {
							e2.printStackTrace();
							break;
						}

					}
				});
				serverThread.start();
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
				s.close();
				serverThread.interrupt();
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
		primaryStage.setTitle("예제용 JavaFX");
		primaryStage.setOnCloseRequest(e -> {
			System.exit(0);
		});
		primaryStage.show();
	}

	public static void main(String[] args) {
		// 현재 사용되는 Thread 의 이름을 출력할꺼에요!
		System.out.println(Thread.currentThread().getName());
		launch();

	}

	class MyEchoRunnalbe implements Runnable {
		private Socket s;

		public MyEchoRunnalbe(Socket s) {
			this.s = s;
		}

		@Override
		public void run() {
			try {
				printMSG(Thread.currentThread().getName() + "님이 입장하였습니다!");
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter pw = new PrintWriter(s.getOutputStream());
				String revString = "";
				while (true) {
					revString = br.readLine();
					if (revString == null || revString.equals("@EXIT")) {
						break;
					}
					pw.println(revString);
					pw.flush();
				}
				if (pw != null)
					pw.close();
				if (br != null)
					br.close();
				if (s != null)
					s.close();
				printMSG(Thread.currentThread().getName() + "님이 퇴장하셨습니다!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
