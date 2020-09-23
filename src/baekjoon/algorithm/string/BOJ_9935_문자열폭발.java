package baekjoon.algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String bomb = br.readLine();

		System.out.println(checkString(input, bomb));
	}

	private static String checkString(String input, String bomb) {
		StringBuilder stb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			stb.append(input.charAt(i));
			
			if(stb.length() < bomb.length())
				continue;
			
			if(bomb.equals(stb.substring(stb.length() - bomb.length(), stb.length()))) {
				stb.delete(stb.length() - bomb.length(), stb.length());
			}
		}
		if(stb.length() > 0) {
			return stb.toString();
		}else {
			return "FRULA";
		}
	}
}
