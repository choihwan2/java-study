package baekjoon.algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class HideAndSeek4 {
	static final int MAX = 200000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int subin_p = Integer.parseInt(in[0]);
		int sister_p = Integer.parseInt(in[1]);

		int[] list_p = new int[MAX];
		boolean[] bool_p = new boolean[MAX];
		Queue<Integer> que = new LinkedList<Integer>();
		int answer = 0;

		list_p[subin_p] = 0;
		bool_p[subin_p] = true;
		que.add(subin_p);
		
		/*
		 * DFS 는 큐를 활용해야 한다. 처음의 root 노드를 넣고 그거ㅓㅅ과 연결 되어서 처리해야하는 로직들을 이해해보자.
		 * 큐에 root 넣어주기 => 방문처리 => 큐에 들어가있는것 뽑아내기 =>
		 * root 와 이어진 아이들 방문했는지 확인하고 방문하지 않았으면 큐에 넣고 방문처리
		 * 
		 */
		while (!que.isEmpty()) {
			int v = que.poll();
			if (v - 1 >= 0) {
				if (!bool_p[v - 1]) {
					bool_p[v - 1] = true;
					que.add(v - 1);
					list_p[v - 1] = list_p[v] + 1;
				}
			}

			if (v + 1 < MAX) {
				if (!bool_p[v + 1]) {
					bool_p[v + 1] = true;
					que.add(v + 1);
					list_p[v + 1] = list_p[v] + 1;
				}
			}
			if (v * 2 < MAX) {
				if (!bool_p[v * 2]) {
					bool_p[v * 2] = true;
					que.add(v * 2);
					list_p[v * 2] = list_p[v] + 1;
				}
			}
		}
		answer = list_p[sister_p];
		System.out.println(answer);
		Stack<Integer> stack = new Stack<>();
		stack.add(sister_p);
		while (list_p[stack.peek()] != 0) {
			int top = stack.peek();
			int num = list_p[top];

			if (top - 1 >= 0) {
				if (list_p[top - 1] == num - 1) {
					stack.add(top - 1);
					continue;
				}
			}

			if (top + 1 < MAX) {
				if (list_p[top + 1] == num - 1) {
					stack.add(top + 1);
					continue;
				}
			}

			if (top > 0) {
				if (list_p[top / 2] == num - 1) {
					stack.add(top / 2);
					continue;
				}
			}
		}
		StringBuilder stb = new StringBuilder();
		while (!stack.isEmpty()) {
			stb.append(stack.pop());
			stb.append(" ");
		}
		System.out.println(stb.toString());

	}

}
