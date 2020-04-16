package backjoon.algorthim.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Problem1021 {
	static int q_size, arr_size;
	static int[] num_arr;
	static int pos = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		Deque<Integer> deque = new LinkedList<Integer>();

		q_size = Integer.parseInt(input[0]);
		arr_size = Integer.parseInt(input[1]);
		num_arr = new int[arr_size];
		for (int i = 1; i <= q_size; i++) {
			deque.add(i);
		}
		String[] num_str = br.readLine().split(" ");
		for (int i = 0; i < num_str.length; i++) {
			num_arr[i] = Integer.parseInt(num_str[i]);
		}
		

	}
}
