package selftest.java.mythread.procon;

/*
 * 생산자 : 1개의 Thread로 표현
 * 무언가를 지속적으로 생성하는 역활을 하는 Thread
 * 숫자를 0 부터 1씩 증가해서 계속 만들어내는 역활
 * 만들어진 숫자를 공용객체에 저장
 * => LinkedList 첫번째 칸에는 0, 두번재 칸에는 1
 * 
 * 소비자 : 3개의 Thread로 표현
 * 세명이 동시에 공용객체에 접근해서 경쟁적으로 값을 가져온다.
 * 세개의 스레드가 어느 정도는 공평하게 값을 나눠가져야한다!
 * 
 */
public class ProducerConsumerTest {
	public static void main(String[] args) {
		// 1. 데이터에 대한 동기화 처리가 있어야 해요! => 공유객체의 필요.
		// 공유객체를 만들때 이 객체가 가지고 있어야할 자료구조.
		// 이 자료규조들을 각 Thread 를 이용할때 method 를 이용해야하는데 어떤 method가 필요한지 생각

		SharedObject obj = SharedObject.getInstance();

		Thread producer = new Thread(new Producer(obj));
		Thread con1 = new Thread(new Consumer(obj));
		Thread con2 = new Thread(new Consumer(obj));
		Thread con3 = new Thread(new Consumer(obj));

		// 3. 각 thread 를 시작!

		con1.start();
		con2.start();
		con3.start();
		producer.start();

		try {
			Thread.sleep(2);
			producer.interrupt();
			Thread.sleep(2);
			con1.interrupt();
			con2.interrupt();
			con3.interrupt();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
