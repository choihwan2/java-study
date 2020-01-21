package programmers.stack.que;

import java.util.LinkedList;
import java.util.Queue;

public class Test02 {

	public static void main(String[] args) {
		int[] d = {7,4,5,6};
		System.out.println(solution(2, 10, d));
		

	}

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int now_weight = 0;
		Queue<Train> queue = new LinkedList<Train>();

		for (int i = 0; i < truck_weights.length; i++) {

			if (now_weight + truck_weights[i] <= weight) { // 지금 무게에서 들어올수있니?
				now_weight += truck_weights[i];
				queue.offer(new Train(truck_weights[i]));

				for (Train train : queue) {
					train.time++;
				}
				answer++;
			} else if (now_weight + truck_weights[i] > weight) { // now_weight 가 변경된 시점이라 에러, 고쳐야함.
				while (queue.peek().time != bridge_length) {
					for (Train train : queue) {
						train.time++;
					}
					answer++;
				}
				now_weight -= queue.poll().weight;
				i--;
			}
		}
		return answer;
	}

}

class Train {
	int time = 0;
	int weight;

	public Train() {
		weight = 0;
	}

	public Train(int weight) {
		this.weight = weight;
	}

	public Train(int time, int weight) {
		super();
		this.time = time;
		this.weight = weight;
	}

}
