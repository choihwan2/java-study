package baekjoon.algorithm.day03;

import java.util.ArrayList;
import java.util.Scanner;

public class EnergyCollect {
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(scanner.nextInt());
		}
		go(0, list);
		System.out.println(MAX);
		scanner.close();

	}

	public static void go(int sum, ArrayList<Integer> list) {
		if (list.size() == 2) {
			MAX = Math.max(MAX, sum);
			return;
		}
		for (int i = 1; i < list.size() - 1; i++) {
			int left = list.get(i - 1);
			int right = list.get(i + 1);
			int temp = left * right;
			ArrayList<Integer> tempList = new ArrayList<>(list);
			tempList.remove(i);
			go(sum + temp, tempList);
		}
	}

}
