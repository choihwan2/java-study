package programmers.school.day02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelop {
	public int[] solution(int[] progresses, int[] speeds) {
		ArrayList<Integer> answerList = new ArrayList<>();
		int[] answer = {};

		Queue<Integer> workQ = new LinkedList<Integer>();
		Queue<Integer> speedQ = new LinkedList<Integer>();
		for (int i = 0; i < progresses.length; i++) {
			workQ.add(progresses[i]);
			speedQ.add(speeds[i]);
		}

		while (!workQ.isEmpty()) {
		}

		return answer;
	}
}
