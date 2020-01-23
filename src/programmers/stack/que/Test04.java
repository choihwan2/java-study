package programmers.stack.que;

import java.util.LinkedList;
import java.util.Queue;

public class Test04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp = {1, 1, 9, 1, 1, 1};
		int[] temp2 = {2, 1, 3, 2};
		System.out.println(solution(temp2, 2));
		
		

	}

	public static int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Process> processes_q = new LinkedList<Process>();
		Queue<Process> wait_q = new LinkedList<Process>();
		for (int i = 0; i < priorities.length; i++) {
			processes_q.offer(new Process(priorities[i]));
			if (i == location) {
				processes_q.peek().setTarget(true);
			}
		}
		while (!processes_q.isEmpty()) {
			Process temp = processes_q.peek();
			for (Process process : processes_q) {
				if(temp.priorities < process.priorities) {
					wait_q.offer(processes_q.poll());
					break;
				}
			}
			answer++;
			if (processes_q.poll().target) {
				return answer;
			}
			
			while (!wait_q.isEmpty()) {
				processes_q.offer(wait_q.poll());
			}
		}
		return answer;
	}

}

class Process {
	int priorities;
	boolean target = false;

	public Process(int priorities) {
		super();
		this.priorities = priorities;
	}

	public void setTarget(boolean target) {
		this.target = target;
	}

}
