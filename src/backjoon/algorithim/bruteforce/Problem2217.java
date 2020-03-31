package backjoon.algorithim.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2217 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rope_n = Integer.parseInt(br.readLine());
		int[] rope = new int[rope_n];
		int max = 0;
		for(int i =0; i<rope_n; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		for(int i =0; i<rope_n; i++) {
			max = Math.max(rope[i]* (rope_n - i), max);
		}
		System.out.println(max);
		
	}
}
