package selftest.java.thread.procon;

public class Producer implements Runnable {
	private SharedObject obj;

	public Producer(SharedObject obj) {
		super();
		this.obj = obj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("생성자 Thread  시작!");
		int i = 1;
		while (true) {
			if(Thread.currentThread().isInterrupted()) {
				break;
			}
			obj.put(new Integer(i++).toString());
		}
		
		System.out.println("Producer가 종료되었어요!");

	}

}
