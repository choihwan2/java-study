package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
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

public class Exam04_SharedChatServer extends Application {
	private TextArea ta;
	private Button onBtn, closeBtn;
	private Socket s;
	private ServerSocket server;

	// Thread Pool을 생성 제한된 숫자의 Thread를 가지고 있는 pool 이 아니라 필요한 갯수만큼 Thread 를 가지고 잇는
	// Thread Pool을 생성

	private ExecutorService excutorService = Executors.newCachedThreadPool();
	private MySharedObject obj = new MySharedObject();

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
				server = new ServerSocket(7979);
				Runnable serverRunnable = () -> {
					printMSG("서버를 시작합니다!");
					while (true) {
						try {
							s = server.accept();
							MyEchoRunnable runnable = new MyEchoRunnable(s);
							obj.addRunnable(runnable);
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
				if (s != null)
					s.close();
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

	static class MySharedObject {
		private List<MyEchoRunnable> list = new ArrayList<MyEchoRunnable>();

		public void addRunnable(MyEchoRunnable item) {
			list.add(item);
		}
		
		public void removeRunnable(MyEchoRunnable item) {
			list.remove(item);
		}

		public void sendMsg(String msg) {
			for (MyEchoRunnable myEchoRunnable : list) {
				PrintWriter pw = myEchoRunnable.getPw();
				pw.println(msg);
				pw.flush();
			}
		}
	}

	class MyEchoRunnable implements Runnable {
		private Socket s;
		private BufferedReader br;
		private PrintWriter pw;

		public MyEchoRunnable(Socket s) {
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
				printMSG(Thread.currentThread().getName() + "님이 입장하였습니다!");
				String revString = "";
				while (!Thread.currentThread().isInterrupted()) {
					revString = br.readLine();
					if (revString == null || revString.equals("@EXIT")) {
						obj.removeRunnable(this);
						break;
					}
					obj.sendMsg(revString);
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

		public PrintWriter getPw() {
			return pw;
		}

	}
}
