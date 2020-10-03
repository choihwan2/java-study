package baekjoon.algorithm.greedy;

import java.util.Scanner;

public class BOJ_2566_벽장문의이동 {
	static int N, K, min = Integer.MAX_VALUE, move[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int front = sc.nextInt();
		int rear = sc.nextInt();
		K = sc.nextInt();
		
		if(front > rear) {
			int temp = front;
			front = rear;
			rear = temp;
		}

		move = new int[K];
		for (int i = 0; i < K; i++) {
			move[i] = sc.nextInt();
		}
		process(0, 0, front, rear);
		
		System.out.println(min);
	}

	private static void process(int index, int cnt, int front, int rear) {
		if(min < cnt) {
			return;
		}
		if (index == K) {
			if(cnt < min) {
				min = cnt;
			}
			return;
		}
		
		if(front > rear) {
			int temp = front;
			front = rear;
			rear = temp;
		}

		int target = move[index];
		
		int fGap = Math.abs(front - target);
		int rGap = Math.abs(rear - target);
		
		if(front < target && target < rear) {
			process(index + 1, cnt + fGap, target, rear);
			process(index + 1, cnt + rGap, front, target);
		}else if(front >= target) {
			process(index + 1, cnt + fGap, target, rear);
		}else if(rear <= target) {
			process(index + 1, cnt + rGap, front, target);
		}
		
		
	}
}
