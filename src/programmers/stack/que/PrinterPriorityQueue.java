package programmers.stack.que;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrinterPriorityQueue {
	public static void main(String[] args) {
		int[] priorities = {1,1,9,1,1,1};
		int location = 0;
		
		System.out.println(solution(priorities, location));
	}
	public static int solution(int[] priorities, int location) {
		int answer = 1;
		Queue<Print> que = new PriorityQueue<>(Print.PRINT_ORDER);
		for (int i = 0; i < priorities.length; i++) {
			if (i != location) {
				que.add(new Print(priorities[i], false));
			}else {
				que.add(new Print(priorities[i], true));
			}
		}
		
		while(!que.poll().target) {
			answer++;
		}
		return answer;
	}

	static class Print {
		int priority;
		boolean target;

		public Print(int priority, boolean target) {
			this.priority = priority;
			this.target = target;
		}

		public static final Comparator<Print> PRINT_ORDER = new Comparator<PrinterPriorityQueue.Print>() {

			@Override
			public int compare(Print o1, Print o2) {
				return o1.priority > o2.priority ? -1 : o1.priority == o2.priority ? -1 : 1;
			}
		};
	}
}
