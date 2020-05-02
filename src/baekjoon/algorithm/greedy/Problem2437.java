package baekjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2437 {
	static boolean[] values;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] arr = new int[num];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		System.out.println(find(arr));
	}

	public static int find(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= sum + 1) {
				sum += arr[i];
			} else {
				break;
			}
		}
		return sum + 1;
	}
}
