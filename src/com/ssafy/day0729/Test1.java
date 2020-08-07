package com.ssafy.day0729;

public class Test1 {
	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		String c = new String("hello");
		
		
		char[] ac = a.toCharArray();
		
		
		System.out.println(String.copyValueOf(ac));
		
		char cc = a.charAt(1);
		
		System.out.println(Character.isDigit('5')); // 숫자인가?
		
		int ab = 0b111;
		int ah = 0x111;
		System.out.println(ah);
		
		double da = 234.2342432432;
		System.out.printf("%.2f",da);
		System.out.println();
		System.out.println((int)-1.3);
		
	}
}
