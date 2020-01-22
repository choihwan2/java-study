package programmers.stack.que;

import java.util.LinkedList;
import java.util.Queue;

public class Test02 {

	public static void main(String[] args) {
		int[] test01 = { 7, 4, 5, 6 };
		int[] test02 = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 };
		int[] test03 = { 10 };
		System.out.println(solution2(2, 10, test01));
		System.out.println(solution2(100, 100, test02));
		System.out.println(solution2(100, 100, test03));

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

			} else if (now_weight + truck_weights[i] > weight) { // 무게가 높아서 다리에서 기차를 지나가게 해야해
				while (queue.peek().time != bridge_length) {
					for (Train train : queue) {
						train.time++;
					}
				} // while end
				now_weight -= queue.poll().weight;
				i--; // 그 전의 아이로 돌아가서 다시 들어오게 만들자.
			} // else if end
			answer++; // 1초가 지났다.

			if (i == truck_weights.length - 1) {
				while (!queue.isEmpty()) {
					while (queue.peek().time != bridge_length) {
						for (Train train : queue) {
							train.time++;
						}
						answer++; // 1초가 지났다.
					} // while end
					queue.poll();
				}
				answer++;
			}
		}
		return answer;
	}

	public static int solution2(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		int now_weight = 0;
		Queue<Train> wait_queue = new LinkedList<Train>();
		Queue<Train> on_queue = new LinkedList<Train>();

		for (int i = 0; i < truck_weights.length; i++) {
			wait_queue.offer(new Train(truck_weights[i]));
		}

		now_weight += wait_queue.peek().weight;
		on_queue.offer(wait_queue.poll());
		while (!on_queue.isEmpty()) {
			answer++;
			for (Train train : on_queue) {
				train.time++;
			}

			if (on_queue.peek().time > bridge_length) {
				now_weight -= on_queue.poll().weight;
			}

			if (!wait_queue.isEmpty() && weight >= now_weight + wait_queue.peek().weight ) {
				now_weight += wait_queue.peek().weight;
				wait_queue.peek().time++;
				on_queue.offer(wait_queue.poll());
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
