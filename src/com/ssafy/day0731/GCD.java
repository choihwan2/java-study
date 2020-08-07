package com.ssafy.day0731;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GCD {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] numArr = new long[92];
		numArr[0] = 1;
		numArr[1] = 1;
		for (int i = 2; i < numArr.length; i++) {
			numArr[i] = numArr[i - 2] + numArr[i - 1];
		}
		int iT = Integer.parseInt(br.readLine());
		for (int i = 1; i <= iT; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println("#" + i + " " + numArr[n+1] + " " + numArr[n]);
		}
	}
}
