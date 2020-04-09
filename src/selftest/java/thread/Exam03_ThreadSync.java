package selftest.java.thread;

// 공유객체를 만들기 위한 class, 일반적으로 Singleton 으로 작성
class SharedObject {
	// Thread 가 공유해서 사용하는 공유객체는 Thread가 사용하는 데이터와 로직을 포함
	private int number; // Thread 에 의해서 공유되는 field
	private Object monitor = new Object();	// monitor용 객체

	public int getNumber() {
		return number;
	}

	// 1번째 해결방법은 method 호출을 순차적으로 처리!!
	// 각 Thread가 가지고 있는 공용객체의 method 호출을 순차적으로 호출하게끔 처리한다.
	// method 자체가 동기화 처리가 되서 프로그래밍 하기는 쉬워요!
	// 해당 method의 실행이 만약 오래걸리게 되면 performance에 문제가 발생한다.
	// 전체 method 를 동기화 하는게 아니라 필요한 부분만 동기화를 해요!

	public void setNumber(int number) {
		System.out.println("이것은 소리있는 아우성");
		synchronized (monitor) {
			this.number = number;
			try {
				// 현재 공유 객체를 사용하는 Thread 를 1초간 재워요!
				Thread.sleep(1000);
				System.out.println("현재 number : " + getNumber());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("허허 소리가 없어졌습니다.");

	}

}

class NumberRunnable implements Runnable {

	private SharedObject obj;
	private int number;

	public NumberRunnable() {
	}

	public NumberRunnable(SharedObject obj, int number) {
		this.obj = obj;
		this.number = number;
	}

	@Override
	public void run() {
		// 공유객체가 가지고 있는 기능을 이용해서 숫자를 출력!
		obj.setNumber(number);
	}

}

public class Exam03_ThreadSync {

	// 프로그램의 entry point
	public static void main(String[] args) {

		// Thread에 의해서 공유되는 공유 객체 1개를 생성
		// 일반적으로 공유객체는 class 로 부터 객체가 딱 1개만
		// 생성되는 형태로 만들어져요! => Singleton 패턴으로 만들장
		// 공유객체를 1개 만들어 보아요!!
		// Thread는 로직처리를 공유객체를 이용해서 로직처리를 하고 데이터 처리 역시 공유객체를 통해 처리

		SharedObject obj = new SharedObject();

		// Thread 를 생성하기 위해서 Runnable interface 를 구현한 객체가 있어야한다.
		// 그래서 "Runnable interface 를 구현한 객체" 를 만들기 위한 calss 를 define
		NumberRunnable r1 = new NumberRunnable(obj, 100);
		NumberRunnable r2 = new NumberRunnable(obj, 200);

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

	}

}
