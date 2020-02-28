package selftest.java.datastructure.arrays;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("사람수를 입력해주세요: ");
		int num = scanner.nextInt();
		Random rand = new Random();
		int a = rand.nextInt(num) + 1;
		int[] heights = new int[a];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = 100 + rand.nextInt(90);
		}

		System.out.println(Arrays.toString(heights));
	}

	public static int maxOf(int[] a) {
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}
		return max;
	}
}
