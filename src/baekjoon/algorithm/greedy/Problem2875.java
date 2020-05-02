package baekjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2875 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int girl, man, k;
		girl = Integer.parseInt(input[0]);
		man = Integer.parseInt(input[1]);
		k = Integer.parseInt(input[2]);
		while (k > 0) {
			if (girl > man * 2) {
				k--;
				girl--;
			} else if (girl <= man * 2) {
				k--;
				man--;
			}
		}
		int max = Math.min(girl, man*2);
		System.out.println(max/2);
		
	}
}
