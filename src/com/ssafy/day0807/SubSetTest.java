package com.ssafy.day0807;

import java.util.ArrayList;

public class SubSetTest {
	static int R = 5;
	static int[] A = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {
		subset(0, 0, new ArrayList<String>());
	}

	private static void subset(int cnt, int sum, ArrayList<String> list) {
		if (R == cnt) {
			System.out.print(list.toString() + " ");
			System.out.println(sum);
			return;
		}
		list.add(A[cnt] + "");
		subset(cnt + 1, sum + A[cnt], list);
		list.remove(A[cnt] + "");
		subset(cnt + 1, sum, list);
	}
}
