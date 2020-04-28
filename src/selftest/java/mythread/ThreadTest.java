package selftest.java.mythread;

public class ThreadTest {
	
	// 프로그램의 entry point
	// 프로그램은 해당 프로그램에서 사용되는 모든 Thread가 종료되는 시점에 프로그램이 종료된다.
	// Java에서 Thread는 어떻게 표현되나요? ==> instance(객체)
	// 당연히 Thread 를 만들기 위한 class 가 존재. =>  Thread class
	// Thread class 를 이용해서 thread 객체를 생성하는데 2가지 방식으로 생성한다.
	// 1. 상속 을 이용한 Thread 구현
	// 2. interface를 구현.
	// 상속의 문제는 결속력이 너무 높아진다. 부모가 문제가 되면 자식도 문제가 된다. 재사용에 있어서 부모와 자식 둘다 들고다녀야함. 하지만 편하게 들고다니는 장점도 있음.
	// 

	public static void main(String[] args) {
		System.out.println("Thread에 대해서 알아보자!");
		Mythread t = new Mythread(); // t :  thread instance
		// thread 를 실행 시키려면 method 를 호출해야함 => start()라는 메소드를 호출
		// run()이라는 메소드를 호출하지 않고 start() 라는걸로 호출해서 run()을 부름
		t.start();	// JVM 에 요청하는거다. JVM 이 실행 가능할때 실행시켜줌. 그리고 main()은 멈추지 않는다. 
		//그래서 이 요청으로 인해서 JVM 에서 쓰레드가 언제 수행될지 모른다. 그래서 개발자는 어렵당..
		System.out.println("끝!");
		
		
		MyRunnable runnable = new MyRunnable();
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(()->{
			System.out.println("허허");
		});
		t2.start();
		
	}
	
}
class Mythread extends Thread{

	// 독립적인 실행흐름이 있어야한다!
	// method로 독립적인 실행 흐름을 표현
	
	@Override
	public void run() {
		super.run();
		System.out.println("MyThread 입니다.");
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
