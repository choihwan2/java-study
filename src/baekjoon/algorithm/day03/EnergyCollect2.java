package baekjoon.algorithm.day03;

import java.util.Scanner;

public class EnergyCollect2 {
	static int MAX = Integer.MIN_VALUE;
	static int[] energyArr;
	static boolean[] energyBool;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		energyArr = new int[N];
		energyBool = new boolean[N];
		for (int i = 0; i < N; i++) {
			energyArr[i] = scanner.nextInt();
		}
		go(0, 0);
		System.out.println(MAX);
		scanner.close();

	}

	public static void go(int sum, int index) {
		if (index == energyBool.length - 2) {
			MAX = Math.max(MAX, sum);
			return;
		}
		for (int i = 1; i < energyBool.length - 1; i++) {
			if (energyBool[i])
				continue;
			int l = i - 1;
			int r = i + 1;
			while (energyBool[l]) l--;
			int left = energyArr[l];
			
			while (energyBool[r])r++;
			int right = energyArr[r];
			
			int temp = left * right;

			energyBool[i] = true;
			go(sum + temp, index + 1);
			energyBool[i] = false;
		}
	}

}
