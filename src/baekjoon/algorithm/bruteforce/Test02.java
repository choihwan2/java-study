package baekjoon.algorithm.bruteforce;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(solution(n));
		scanner.close();

	}

	public static int solution(int num) {
		int answer = 0;
		int temp = 0;
		while (true) {
			if (answer > num) {
				return 0;
			}
			String numString = Integer.toString(answer);
			temp = 0;
			for (int i = 0; i < numString.length(); i++) {
				temp += numString.charAt(i) - '0';
			}
			if(answer + temp == num) {
				return answer;
			}
			answer++;
		}
	}
}
