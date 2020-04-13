//package selftest.java.thread;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ThreadPoolExecutor;
//
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextArea;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.FlowPane;
//import javafx.stage.Stage;
//
///*
// * Pool 개념
// * Java는 필요한 객체를 생성하고(new) -> Heap 영역에 메모리가 할당된다.
// * 메모리를 이용해서 여러가지 처리를 한다! (데이터를 저장하고 method 호출을 통해 로직을 처리한다!)
// * -> 객체를 다 사용하고 더 이상 사용하지 않으면 Garbage collector 가 사용하지 않는 객체를 메모리에서 제거!
// * 
// * 이런 일반적인 방식은 효율면에서 좋지 않아요!
// * 
// * 사용할 객체를 일단 미리 많이 생성해서 모아놔요!
// * Pool 이라고 불리는 공간에 모아놔요!
// * 필요할때마다 Pool 안에서 객체를 가져다가 사용한다. 객체를 사용한 후 
// * 사용이 끝나면 Pool 에 반납한다. (속도를 많이 높여준다)
// * 
// * 가장 대표적인 활용 => Database Connection Pool(DBCP)
// * 				    Object Pool
// * 					Thread Pool
// * 
// * Thread 사용할 때 Thread t = new Thread(); 방식을 사용했지만
// * 이번에는 Thread Pool 을 이용해서 처리해 보아요!
// * ExcutorService 라는 이름의 Thread Pool 을 이용할꺼에요!
// * 
// */
//public class Exam07_ThreadPoolBasic extends Application {
//	private TextArea ta;
//	private Button initBtn, startBtn, shutdownBtn;
//	// initBtn : Thread Pool 을 생성하는 버튼
//	// shutdownBtn : Thread Pool 을 종룧나느 버튼
//	// startBtn : Thread Pool 안에서 Thread 를 가져다가 사용하는 버튼
//	private ExecutorService executorService;
//	// ExcutorService : Thread Pool class;
//
//	private void printMSG(String msg) {
//		Platform.runLater(() -> {
//			ta.appendText(msg + "\n");
//		});
//	}
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		System.out.println(Thread.currentThread().getName());
//		BorderPane root = new BorderPane();
//		root.setPrefSize(700, 500);
//		ta = new TextArea();
//		root.setCenter(ta);
//
//		initBtn = new Button("Thread Pool 생성");
//		initBtn.setPrefSize(200, 50);
//		initBtn.setOnAction(e -> {
//			// java lambda를 이용한 event 처리 코드 작성
//			// executorService = Executors.newFixedThreadPool(5);
//			executorService = Executors.newCachedThreadPool();
//			printMSG("Pool안의 Thread개수 : " + ((ThreadPoolExecutor) executorService).getPoolSize());
//		});
//
//		startBtn = new Button("Thread 생성");
//		startBtn.setPrefSize(250, 50);
//		startBtn.setOnAction(e -> {
//			// Thread Pool에서 Thread를 가져다가 사용하는 코드
//			// 10개의 Thread를 Thread pool에서 가져다가 사용해 보아요!
//			for (int i = 0; i < 10; i++) {
//				// 1. Runnable interface를 구현한 객체를 생성
//				// 2. Thread Pool을 이용해서 Thread 생성.
//				Runnable runnable = new Runnable() {
//					@Override
//					public void run() {
//						String msg = "Thread Pool안의 개수 : " + ((ThreadPoolExecutor) executorService).getPoolSize();
//						msg += ", Thread Name : " + Thread.currentThread().getName();
//						printMSG(msg);
//					}
//				};
//				executorService.execute(runnable);
//				// new Thread()로 Thread를 생성해서 만드는 방식보다
//				// Thread Pool을 이용하는게 일반적인 방식!!
//			}
//		});
//
//		shutdownBtn = new Button("Thread Pool 종료");
//		shutdownBtn.setPrefSize(250, 50);
//		shutdownBtn.setOnAction(e -> {
//			executorService.shutdownNow();
//		});
//		FlowPane flowpane = new FlowPane();
//		flowpane.setPrefSize(700, 50);
//		flowpane.getChildren().add(initBtn);
//		flowpane.getChildren().add(startBtn);
//		flowpane.getChildren().add(shutdownBtn);
//
//		root.setBottom(flowpane);
//
//		Scene scene = new Scene(root);
//		primaryStage.setScene(scene);
//		primaryStage.setTitle("예제용 JavaFX");
//		primaryStage.setOnCloseRequest(e -> {
//
//		});
//		primaryStage.show();
//	}
//
//	public static void main(String[] args) {
//		// 현재 사용되는 Thread 의 이름을 출력할꺼에요!
//		System.out.println(Thread.currentThread().getName());
//		launch();
//
//	}
//
//}
