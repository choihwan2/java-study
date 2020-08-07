package com.ssafy.day0731;

public class FactTest1 {
	public static void main(String[] args) {
		System.out.println(fact(29));
	}

	public static long fact(long n) {
		if (n <= 1L) {
			return 1;
		} else {
			return n * fact(n - 1);
		}
	}
}
