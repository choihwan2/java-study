package programmers.perfectsearch;

import java.util.ArrayList;

public class NumberBaseball {

	public static void main(String[] args) {
		int[][] baseball = { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } };
		System.out.println(solution(baseball));

	}

	public static int getStrike(String baseball, String num) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			if (baseball.charAt(i) == num.charAt(i))
				strike++;
		}
		return strike;
	}

	public static int getBall(String baseball, String num) {
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != j && baseball.charAt(i) == num.charAt(j)) {
					ball++;
				}
			}
		}
		return ball;
	}

	public static int solution(int[][] baseball) {
		int answer = 0;
		ArrayList<Integer> num_list = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if (i != j) {
					for (int k = 1; k < 10; k++) {
						if (i != k && j != k) {
							int num = i * 100 + j * 10 + k;
							num_list.add(num);
						}
					}
				}
			}
		}

		for (int i = 0; i < num_list.size(); i++) {
			boolean isRight = true;
			for (int j = 0; j < baseball.length; j++) {
				int strike = getStrike(String.valueOf(baseball[j][0]), String.valueOf(num_list.get(i)));
				int ball = getBall(String.valueOf(baseball[j][0]), String.valueOf(num_list.get(i)));
				if (strike != baseball[j][1] || ball != baseball[j][2]) {
					isRight = false;
					break;
				}
			}
			if (isRight) {
				answer++;
			}
		}
		return answer;
	}

}
