package programmers.stack.que;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test03 {
	public static void main(String[] args) {

	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] answer;
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int temp = 0;
		Queue<Progress> work_que = new LinkedList<Progress>();
		for (int i = 0; i < progresses.length; i++) {
			work_que.offer(new Progress(progresses[i], speeds[i]));
		}
		while (!work_que.isEmpty()) {
			temp = 0;
			for (Progress progress : work_que) {
				progress.working();
			}
			while (!work_que.isEmpty() && work_que.peek().progress >= 100) {
				work_que.poll();
				temp++;
			}
			if(temp != 0) {
				arrayList.add(temp);
			}

		}
		answer = new int[arrayList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arrayList.get(i);
		}
		return answer;
	}

}

class Progress {
	int progress = 0;
	int speed = 0;

	public Progress(int progress, int speed) {
		super();
		this.progress = progress;
		this.speed = speed;
	}

	public void working() {
		progress += speed;
	}

}
