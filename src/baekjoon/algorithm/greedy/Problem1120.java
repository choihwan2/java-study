package baekjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1120 {
	//adaabc aababbc 2
	//		 adaabc
	//	     0adaabc
	//		 aaaababbc
	// 어디에 들어가는지가 관건이다.
	//3 1 1 1          3 3 1 0
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int min = 50;
		
		for (int i = 0; i <= input[1].length() - input[0].length(); i++) {
			int temp = 0;
			for (int j = 0; j < input[0].length(); j++) {
				if(input[0].charAt(j) != input[1].charAt(i+j))
					temp++;
			}
			min = Math.min(min, temp);
		}
		System.out.println(min);

	}

}
