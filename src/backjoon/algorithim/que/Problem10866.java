package backjoon.algorithim.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Problem10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		int front = 0;
		int back = num - 1;
		int[] deque = new int[1000000];
		Deque<Integer> deque2 = new LinkedList<>();
		ArrayList<Integer> arrayList = new ArrayList<>();
		LinkedList<Integer> linkedList = new LinkedList<>();
		
		for (int i = 0; i < num; i++) {
			String[] input = bf.readLine().split(" ");
			if (input[0].equals("push_front")) {
				deque[front++] = Integer.parseInt(input[1]);
			} else if (input[0].equals("push_back")) {
				deque[back--] = Integer.parseInt(input[1]);
			} else if (input[0].equals("pop_front")) {
				if (front != 0) {
					System.out.println(deque[--front]);
				} else {
					System.out.println(-1);
				}
			} else if (input[0].equals("pop_back")) {
				if (back != num -1) {
					System.out.println(deque[++back]);
				} else {
					System.out.println(-1);
				}
			} else if (input[0].equals("size")) {
				int size = front + (num - back -1);
				System.out.println(size);
			} else if (input[0].equals("front")) {
				if (front != 0) {
					System.out.println(deque[front-1]);
				} else {
					System.out.println(-1);
				}
			} else if (input[0].equals("back")) {
				if (back != num -1) {
					System.out.println(deque[back+1]);
				} else {
					System.out.println(-1);
				}
			} else if (input[0].equals("empty")) {
				if (front == 0 && back == (num -1)) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}
		}
	}
}
