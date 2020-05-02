package baekjoon.algorithm.string;

import java.util.Scanner;

public class Problem2941 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] croa = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };
		String input = scanner.nextLine();
		for (String temp : croa) {
			StringBuilder str = new StringBuilder();
			input = input.replace(temp, "0");
		}
		System.out.println(input.length());
	}
}
