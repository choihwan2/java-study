package programmers.school.day01;

import java.util.ArrayList;

public class MakeBinaryNumber {
    static boolean[] boolArr;
	static ArrayList<Integer> binList;
	static int answer;

	public int solution(int[] nums) {
		answer = 0;
		boolArr = new boolean[3000];
		binList = new ArrayList<>();

		boolArr[2] = true;
		binList.add(2);
		for (int i = 3; i < boolArr.length; i += 2) {
			boolean isBin = true;
			for (int j : binList) {
				if (i % j == 0) {
					isBin = false;
					break;
				}
			}
			if (isBin) {
				boolArr[i] = true;
				binList.add(i);
			}
		}
		// 소수배열을 먼저 만들어놓고 해야함.
		dfs(0, nums, 0, 0);
		return answer;
	}


	public void dfs(int start, int[] nums, int num, int sum) {
		if (num == 3) {
			if (boolArr[sum])
				answer++;
			return;
		}
		for (int i = start; i < nums.length; i++) {
			dfs(i + 1, nums, num + 1, sum + nums[i]);
		}
	}
}
