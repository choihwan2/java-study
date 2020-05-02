package baekjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Problem1018 {

	static String[] chess = { "WBWBWBWB", "BWBWBWBW" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		String[] board = new String[Integer.parseInt(input[0])];
		for (int i = 0; i < Integer.parseInt(input[0]); i++) {
			board[i] = br.readLine();
		}
	}
}
