package backjoon.algorthim.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2455 {

	public static void main(String[] args) throws IOException {
		int p_num = 0;
		int max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i =0; i< 4; i++) {
			String[] in_arr = br.readLine().split(" ");
			int join_num = Integer.parseInt(in_arr[0]);
			int out_num = Integer.parseInt(in_arr[1]);
			p_num -= join_num;
			p_num += out_num;
			max = Math.max(p_num, max);
		}
		System.out.println(max);
	}

}
