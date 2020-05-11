package baekjoon.algorithm.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Inequality {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] inequal_arr = br.readLine().replace(" ", "").toCharArray();
		Stack<Integer> max_s = new Stack<>();
		Stack<Integer> min_s = new Stack<>();

		int max_ptr = 9;
		int min_ptr = 0;

		StringBuilder max_stb = new StringBuilder();
		StringBuilder min_stb = new StringBuilder();

		max_s.add(max_ptr--);
		min_s.add(min_ptr++);
		for (Character inequal : inequal_arr) {
			if (inequal == '<') {
				max_s.add(max_ptr--);
				while (!min_s.isEmpty()) {
					min_stb.append(min_s.pop());
				}
				min_s.add(min_ptr++);
			} else {
				min_s.add(min_ptr++);
				while (!max_s.isEmpty()) {
					max_stb.append(max_s.pop());
				}
				max_s.add(max_ptr--);
			}
		}
		while (!max_s.isEmpty())
			max_stb.append(max_s.pop());
		while (!min_s.isEmpty())
			min_stb.append(min_s.pop());
		
		System.out.println(max_stb.toString());
		System.out.println(min_stb.toString());
	}
}
