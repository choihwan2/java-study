package backjoon.algorithim.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int case_num = Integer.parseInt(bf.readLine());
		int front = 0;
		int rear = 0;
		int num = 0;
		int[] deque = new int[1000000];
		int max = deque.length;

		for (int i = 0; i < case_num; i++) {
			String[] input = bf.readLine().split(" ");
			if (input[0].equals("push_front")) {
				if(--front < 0)
					front = max -1;
				deque[front] = Integer.parseInt(input[1]);
				num++;
			} else if (input[0].equals("push_back")) {
				deque[rear++] = Integer.parseInt(input[1]);
				num++;
			} else if (input[0].equals("pop_front")) {
				if (num<=0) {
					System.out.println(-1);
				}else {
					System.out.println(deque[front++]);
					if(front == max)
						front =0;
					num--;
				}
			} else if (input[0].equals("pop_back")) {
				if(num <= 0) {
					System.out.println(-1);
				}else {
					if(--rear <0)
						rear = max - 1;
					System.out.println(deque[rear]);
					num--;
				}
			} else if (input[0].equals("size")) {
				System.out.println(num);
			} else if (input[0].equals("front")) {
				if (num<=0) {
					System.out.println(-1);
				}else {
					System.out.println(deque[front]);
				}
			} else if (input[0].equals("back")) {
				if (num<=0) {
					System.out.println(-1);
				}else {
					System.out.println(deque[rear -1 == 0 ? max -1 : rear -1]);
				}
			} else if (input[0].equals("empty")) {
				if (num<=0) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
		}
	}
}
