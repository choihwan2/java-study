package baekjoon.algorithm.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem1152 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		StringTokenizer stz = new StringTokenizer(str);
		System.out.print(stz.countTokens());
	}
}
