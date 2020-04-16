package javaNetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Exam01_Client2 extends Application {
	private TextArea ta, input;
	private Button btn;

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
		input = new TextArea();
		input.setPrefSize(450, 50);
		root.setCenter(ta);

		btn = new Button("메시지보내기");
		btn.setPrefSize(250, 50);
		btn.setOnAction(e -> {
			try {
				Socket s = new Socket("localhost", 5556);
				OutputStream out = s.getOutputStream();
				String sendMsg = input.getText();
				out.write(sendMsg.getBytes());

				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String getMsg = br.readLine();
				printMSG(getMsg);
				// 처리가 끝나면 Stream 을 닫고 Socket 을 닫아요!
				if (getMsg.equals("@EXIT")) {
					br.close();
					s.close();
				}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		FlowPane flowpane = new FlowPane();
		flowpane.setPrefSize(700, 50);
		flowpane.getChildren().add(input);
		flowpane.getChildren().add(btn);

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
