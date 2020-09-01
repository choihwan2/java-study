package baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5582_공통부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int answer = 0;
		for (int i = 0; i < s1.length(); i++) {
			if(answer > s1.length() - i) {
				break;
			}
			char c1 = s1.charAt(i);
			for (int j = 0; j < s2.length(); j++) {
				char c2 = s2.charAt(j);
				if (c1 == c2) {
					int cnt = countString(i, j, s1, s2);
					if(answer < cnt) {
						answer = cnt;
					}
				}
			}
		}
		System.out.println(answer);
	}

	private static int countString(int i, int j, String s1, String s2) {
		int cnt = 0;
		while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
			i++;
			j++;
			cnt++;
		}
		return cnt;
	}
}
