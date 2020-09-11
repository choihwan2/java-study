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
		for (String str : stringSet) {
			makePartString(str, str, 0, str.length());
		}

		for (String string : answerSet) {
			System.out.println(string);
		}
		System.out.println(answerSet.size());
	}

	private static void makePartString(String baseStr, String divStr, int s, int e) {
		if (divStr.length() <= 2) {
			answerSet.add(baseStr);
			return;
		}

		int len = divStr.length();
		if (len % 2 == 0) {
			String str1 = divStr.substring(0, len / 2);
			String str2 = divStr.substring(len / 2, len);
			StringBuilder stb1 = new StringBuilder(str1);
			StringBuilder stb2 = new StringBuilder(str2);

			// 왼쪽을 선택 => 역순으로 돌린다 그다음 오른쪽을 나눠줘야할 문자열로 넘겨줌
			StringBuilder newWord = new StringBuilder(baseStr);
			newWord.replace(s, e / 2, stb1.reverse().toString());
			makePartString(newWord.toString(), str2, e / 2, e);

			newWord = new StringBuilder(baseStr);
			newWord.replace(e / 2, e, stb2.reverse().toString());
			makePartString(newWord.toString(), str1, s, e / 2);
		} else {
			String str1 = divStr.substring(0, len / 2);
			String str2 = divStr.substring(len / 2, len);
			StringBuilder stb1 = new StringBuilder(str1);
			StringBuilder stb2 = new StringBuilder(str2);

			StringBuilder newWord = new StringBuilder(baseStr);
			newWord.replace(s, s + len / 2, stb1.reverse().toString());
			makePartString(newWord.toString(), str2, s + len / 2, e);

			newWord = new StringBuilder(baseStr);
			newWord.replace(s + len / 2, e, stb2.reverse().toString());
			makePartString(newWord.toString(), str1, s, s + len / 2);

			str1 = divStr.substring(0, len / 2 + 1);
			str2 = divStr.substring(len / 2 + 1, len);

			stb1 = new StringBuilder(str1);
			stb2 = new StringBuilder(str2);

			newWord = new StringBuilder(baseStr);
			newWord.replace(s, s + len / 2 + 1, stb1.reverse().toString());
			makePartString(newWord.toString(), str2, s + len / 2 + 1, e);

			newWord = new StringBuilder(baseStr);
			newWord.replace(s + len / 2 + 1, e, stb1.reverse().toString());
			makePartString(newWord.toString(), str1, s, s + len / 2 + 1);

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
