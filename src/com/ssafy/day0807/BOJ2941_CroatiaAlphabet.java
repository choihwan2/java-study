package com.ssafy.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941_CroatiaAlphabet {
	/*
	 * c= c- dz= d- lj nj s= z=
	 */
	static final String[] cratia = { "dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z=" };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		for (int i = 0; i < cratia.length; i++) {
			input = input.replace(cratia[i], "x");
		}
		System.out.println(input.length());
	}

}
