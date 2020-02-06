package backjoon.algorithim.bruteforce;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] num = new int[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = scanner.nextInt();
		}
		Arrays.sort(num);
		System.out.println(solution(num, M));

		scanner.close();
	}
	
	public static int solution(int[] num, int M) {
		int answer = 0;
		for (int i = 0; i < num.length - 2; i++) {
			for (int j = i + 1; j < num.length - 1; j++) {
				for (int k = j + 1; k < num.length; k++) {
					int temp = num[i] + num[j] + num[k];
					if(temp < M && temp > answer) {
						answer = temp;
						continue;
					}
					if(temp == M) {
						return M;
					}
				}
			}
		}
		return answer;
	}

}
