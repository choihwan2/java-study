package selftest.java.datastructure.que;

public class QueueTest {

}

class IntQueue {
	private int max;
	private int front;
	private int rear;
	private int num;
	private int[] que;

	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
		}
	}

	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
			// TODO Auto-generated constructor stub
		}
	}

	public IntQueue(int capacity) {
		num = front = rear = 0;
		max = capacity;
		try {
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	public int enque(int x) throws OverflowIntQueueException{
		if(num >= max) {
			throw new OverflowIntQueueException();
		}
		que[rear++] = x;
		num++;
		
		if(rear == max)
			rear = 0;
		
		return x;
		
	}
	
	public int deque() throws EmptyIntQueueException{
		if (num <= 0) throw new EmptyIntQueueException();
		
		int x = que[front++];
		num--;
		
		if(front == max)
			front =0;
		return x;
	}
}
