package selftest.java.thread;

// 1초 마다 자신의 이름을 도스창에 출력
// 한번씩 번갈아서 출력 => 순서를 제어하고싶다!
// 일반적인 방식으로는 할수 없다. Thread Scheduler 에 의해서 Thread 가 제어되기 떄문에

// 특수한 method 를 이용해서 Thread 실행 순서를 제어해보아요!!
// wait(), notify(), notifyAll() method 를 이용해서 제어해요!
// => 이 method는 반드시 .. 임계영역(Critical Section 에서만 사용가능!
// => Critical Section => 동기화 코드가 적용된 부분.
class Shared {
	// 쓰레드가 공용으로 사용하는 데이터와 함수가 존재 => 로직처리
	// synchronized keyword 를 이용하면 monitor 를 가져오게 되요!
	public synchronized void printNum() {
		// Thread의 이름과 숫자를 찍어주는 로직 처리
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " : " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
				notify(); // wait으로 block 되어 있는 Thread를 깨우는 method
				wait(); // 자신이 갖고있는 모니터를 놓고 block상태로 빠진다. 누군가 깨워주지 않으면 평생 기다린다.
				//
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class NumberRunnable2 implements Runnable {

	private Shared obj;

	public NumberRunnable2(Shared obj) {
		super();
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.printNum();
	}

}

public class Exam04_ThreadSync2 {

	// 프로그램의 entry point
	public static void main(String[] args) {
		Shared obj = new Shared();

		NumberRunnable2 r1 = new NumberRunnable2(obj);
		NumberRunnable2 r2 = new NumberRunnable2(obj);

		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);

		t1.start();
		t2.start();

	}

}
