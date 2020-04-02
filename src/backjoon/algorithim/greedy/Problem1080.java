package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1080 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		boolean[][] first = new boolean[Integer.parseInt(input[0])][Integer.parseInt(input[1])];
		boolean[][] second = new boolean[Integer.parseInt(input[0])][Integer.parseInt(input[1])];
		for (int i = 0; i < first.length; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				first[i][j] = line.charAt(i) == '0' ? false : true;
			}
		}

		for (int i = 0; i < second.length; i++) {
			String line = br.readLine();
			for (int j = 0; j < line.length(); j++) {
				second[i][j] = line.charAt(i) == '0' ? false : true;
			}
		}
		
		

	}

}
