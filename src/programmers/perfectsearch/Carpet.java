package programmers.perfectsearch;

import java.util.Arrays;

public class Carpet {
	/*
	 * RED 의 개수에 따라서 행렬의 행과 열을 짐작하고 두개의 곱이 BROWN 과 RED 값을 더했을때 일치하는지 확인해야한다.
	 */
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(10, 2)));
	}

	public static int[] solution(int brown, int red) {
		int[] answer = new int[2];
		for (int i = red; i >= 0; i--) {
			if (red % i == 0) {
				int v = red / i; // red + 2 = x, i +2 = y
				if (find(i, v, red, brown)) {
					answer[0] = i + 2;
					answer[1] = v + 2;
					break;
				}
			}
		}
		return answer;
	}

	public static boolean find(int x, int y, int red, int brown) {
		boolean isRight = false;
		int carpet_s = (x + 2) * (y + 2);
		if (carpet_s == red + brown) {
			isRight = true;
		}
		return isRight;
	}
	//35분 걸림..
}
