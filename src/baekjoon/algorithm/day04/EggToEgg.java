package baekjoon.algorithm.day04;

import java.util.Scanner;

public class EggToEgg {
	static int[] durability;
	static int[] weight;
	static int N;
	static int answer = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		N = s.nextInt();
		durability = new int[N];
		weight = new int[N];

		for (int i = 0; i < N; i++) {
			durability[i] = s.nextInt();
			weight[i] = s.nextInt();
		}
		go(0);
		System.out.println(answer);
		s.close();
	}

	public static void go(int index) {
		if (index == N) {
			int temp = 0;
			for (int i : durability) {
				if (i <= 0)
					temp++;
			}
			answer = Math.max(temp, answer);
			return;
		}

		if (durability[index] <= 0) {
			go(index + 1);
			return;
		}
		
		boolean isOne = true;

		for (int i = 0; i < N; i++) {
			/*
			 *  index 번째의 계란으로 안깨진 계란을 찾아서 친다.
			 */
			if (index == i)
				continue;
			if (durability[i] <= 0)
				continue;
			isOne = false;
			durability[i] -= weight[index];
			durability[index] -= weight[i];
			go(index + 1);
			durability[i] += weight[index];
			durability[index] += weight[i];
		}
		if(isOne) {
			go(index + 1);
		}
	}

}
