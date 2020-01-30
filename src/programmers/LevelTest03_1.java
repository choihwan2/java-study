package programmers;

import java.util.StringTokenizer;

public class LevelTest03_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("3people      unFollowed me"));

	}

	public static String solution(String s) {
		StringTokenizer token = new StringTokenizer(s.toLowerCase(), " ");
		StringBuffer answerStringBuffer = new StringBuffer();
		String first = token.nextToken();
		answerStringBuffer.append(first.substring(0, 1).toUpperCase());
		answerStringBuffer.append(first.substring(1));
		while (token.hasMoreTokens()) {
			String str = token.nextToken();
			answerStringBuffer.append(" ");
			answerStringBuffer.append(str.substring(0, 1).toUpperCase());
			answerStringBuffer.append(str.substring(1));
		}
		return answerStringBuffer.toString();
	}

	public static String solution2(String s) {
		String[] arr_str = s.split(" ");
		StringBuilder stringBuilder = new StringBuilder();
		if (arr_str[0].charAt(0) >= 'a' && arr_str[0].charAt(0) <= 'z') {
			stringBuilder.append((char) (arr_str[0].charAt(0) + - 32));
		} else {
			stringBuilder.append(arr_str[0].charAt(0));
		}
		stringBuilder.append(arr_str[0].substring(1).toLowerCase());
		for (int i = 1; i < arr_str.length; i++) {
			stringBuilder.append(" ");
			if (arr_str[i].charAt(0) >= 'a' && arr_str[i].charAt(0) <= 'z') {
				stringBuilder.append((char) (arr_str[i].charAt(0) - 32));
			} else {
				stringBuilder.append(arr_str[i].charAt(0));
			}
			stringBuilder.append(arr_str[i].substring(1).toLowerCase());
		}
		return stringBuilder.toString();
	}

	public static String solution3(String s) {
		boolean isNextUpper = true;
		StringBuffer sb = new StringBuffer();
		for (int inx = 0; inx < s.length(); inx++) {
			char c = s.charAt(inx);
			if (inx == 0 || isNextUpper) {
				sb.append(Character.toUpperCase(c));
				isNextUpper = false;
			} else {
				sb.append(Character.toLowerCase(c));
			}

			if (c == ' ') {
				isNextUpper = true;
			}
		}
		return sb.toString();
	}

}
