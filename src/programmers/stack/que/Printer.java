package programmers.stack.que;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp = {2, 1, 3, 2};
		System.out.println(solution(temp, 2));
	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Print> work_que = new LinkedList<Print>();
		Queue<Print> wait_que = new LinkedList<Print>();

		for (int i = 0; i < priorities.length; i++) {
			if (i == location) {
				work_que.offer(new Print(priorities[i], true));
				continue;
			}
			work_que.offer(new Print(priorities[i]));
		}

		while (!work_que.isEmpty()) {
			boolean max = false;
			while (!max) {
				Print tempPrint = work_que.peek();
				for (Print print : work_que) {
					if (tempPrint.priority < print.priority) {
						wait_que.offer(work_que.poll());
						max = false;
						break;
					} else {
						max = true;
					}
				}
			}
			if(work_que.peek().target == true) {
				answer++;
				return answer;
			}else {
				work_que.poll();
				answer++;
				while (!wait_que.isEmpty()) {
					work_que.offer(wait_que.poll());
				}
			}
		}
		return answer;
	}

}

class Print {
	int priority;
	boolean target = false;

	public Print(int priority) {
		super();
		this.priority = priority;
	}

	public Print(int priority, boolean target) {
		super();
		this.priority = priority;
		this.target = target;
	}

}
