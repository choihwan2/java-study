package backjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1969 {
	static int[][] value_hd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int num = Integer.parseInt(input[0]);
		String[] arr = new String[num];
		int[] hd_arr = new int[num];
		value_hd = new int[num][num];
		for (int i = 0; i < num; i++) {
			arr[i] = br.readLine();
		}
		for (int i = 0; i < value_hd.length; i++) {
			Arrays.fill(value_hd[i], -1);
		}
		Arrays.sort(arr);

		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (i != j) {
					int diff = value_hd[j][i] == -1 ? -1 : value_hd[j][i];
					if (diff == -1) {
						diff = getDiff(arr[i], arr[j]);
						value_hd[i][j] = diff;
					}
					hd_arr[i] += diff;
				}
			}
		}
		int min = findMin(hd_arr);
		System.out.println(arr[min]);
		System.out.println(hd_arr[min]);
	}

	public static int getDiff(String a, String b) {
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				diff++;
		}
		return diff;
	}

	public static int findMin(int[] hd_arr) {
		int min = 51;
		int index = 0;
		for (int i = 0; i < hd_arr.length; i++) {
			if (hd_arr[i] < min) {				
				index = i;
				min = hd_arr[i];
			}
		}
		return index;
	}
}
