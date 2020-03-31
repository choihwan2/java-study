package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10610 {
	// 30 60 90 120 150 180 210 240 270 300 99
	public static void main(String[] args) throws IOException {
		int[] num_arr = new int[10];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		if (!input.contains("0")) {
			System.out.println(-1);
			return;
		}

		for (int i = 0; i < input.length(); i++) {
			num_arr[input.charAt(i) - '0']++;
		}
		int sum = 0;
		for (int i = 1; i < num_arr.length; i++) {
			sum += i * num_arr[i];
		}
		if (sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = num_arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < num_arr[i]; j++) {
				builder.append(i);
			}
		}
		System.out.println(builder.toString());

	}
}
