package backjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem1449 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int L = Integer.parseInt(in[1]);
		Queue<Integer> que = new LinkedList<Integer>();
		int answer = 0;
		String[] input = br.readLine().split(" ");
		int[] hole = new int[N];
		for (int i = 0; i < N; i++) {
			hole[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(hole);
		que.add(hole[0]);
		for (int i = 1; i < hole.length; i++) {
			if(hole[i] - que.peek() + 1 <= L) {
				que.add(hole[i]);
				continue;
			}else {
				que.clear();
				answer++;
				que.add(hole[i]);
			}
		}
		System.out.println(answer + 1);
	}
}
