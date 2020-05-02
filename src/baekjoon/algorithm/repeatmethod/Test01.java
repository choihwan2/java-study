package baekjoon.algorithm.repeatmethod;

import java.util.Scanner;

public class Test01 {
	public static void main(String args[]) {
		System.out.println(factorial(10));
	}

	public static int factorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
