package selftest.java.mythread.procon;

public class Consumer implements Runnable {
	private SharedObject obj;
	int num = 0;
	
	public Consumer(SharedObject obj) {
		this.obj = obj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + " Consumer 시작");
		
		// 반복적으로 공용객체가 가지고 있는 데이터를 뽑아내서 출력!
		while(true) {
			if(Thread.currentThread().isInterrupted()) {
				break;
			}
			System.out.println(Thread.currentThread().getName() + " - " + obj.pop());
			num++;
		}
		System.out.println(Thread.currentThread().getName() + " Thread 종료!" + " num : " + num);
	}
	
	
}
