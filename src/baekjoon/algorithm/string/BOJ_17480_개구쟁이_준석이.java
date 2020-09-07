package baekjoon.algorithm.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_17480_개구쟁이_준석이 {
	static Set<String> answerSet;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] alphaCnt = new int[26];
		int len = 0;
		for (int i = 0; i < n; i++) {
			char c = sc.next().charAt(0);
			int cnt = sc.nextInt();
			alphaCnt[c - 'a'] = cnt;
			len += cnt;
		}
		int[] temp = new int[26];
		String input = sc.next();

		Set<String> stringSet = new HashSet<>();
		answerSet = new HashSet<>();

		int f = 0;
		for (int i = 0; i < input.length(); i++) {
			char lc = input.charAt(i);
			temp[lc - 'a']++;
			if (i >= len) {
				char fc = input.charAt(f++);
				temp[fc - 'a']--;

			}
			if (checkArr(alphaCnt, temp)) {
				stringSet.add(input.substring(f, i + 1));
			}
		}
		for (String string : stringSet) {
			makePartString(string);
		}
	}

	private static void makePartString(String string) {
		
		
		int n = 0;
		int len = string.length();
		if (len % 2 == 0) {
			n = len / 2;
			String first = string.substring(0,n);
			String last = string.substring(n);
			
		} else {
			n = len / 2;
			n = len / 2 + 1;
		}
	}

	private static boolean checkArr(int[] alphaCnt, int[] temp) {
		for (int i = 0; i < temp.length; i++) {
			if (alphaCnt[i] != temp[i])
				return false;
		}
		return true;
	}

}
