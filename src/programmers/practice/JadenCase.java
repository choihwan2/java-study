package programmers.practice;

public class JadenCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(String s) {
		char[] arr = s.toLowerCase().toCharArray();
		boolean isUp = true;
		for (int i = 0; i < arr.length; i++) {
			if (isUp) {
				arr[i] = Character.toUpperCase(arr[i]);
			}
			isUp = false;
			if (arr[i] == ' ') {
				isUp = true;
			}
		}
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			str.append(arr[i]);
		}
		return str.toString();
	}

}
