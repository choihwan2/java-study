package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = bf.readLine().split(" ");
		int answer = 0;
		int[] prices = new int [Integer.parseInt(input[0])];
		int value = Integer.parseInt(input[1]);
		for (int i = 0; i < prices.length; i++) {
			prices[i] = Integer.parseInt(bf.readLine());
		}
		
		for (int i = prices.length - 1; i >= 0; i--) {
			if(prices[i] > value) {
				continue;
			}else {
				int temp = value / prices[i];
				answer += temp;
				value -= prices[i] * temp;
			}
			if (value == 0)
				break;
		}
		
		System.out.println(answer);
	}

}
