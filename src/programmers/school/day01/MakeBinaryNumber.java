package programmers.school.day01;

import java.util.ArrayList;

public class MakeBinaryNumber {
    static boolean[] bin_bool;
	static ArrayList<Integer> bin_arr;
	static int answer;

	public static int solution(int[] nums) {
		answer = 0;
		bin_bool = new boolean[3000];
		bin_arr = new ArrayList<>();

		bin_bool[2] = true;
		bin_arr.add(2);
		for (int i = 3; i < bin_bool.length; i += 2) {
			boolean isBin = true;
			for (int j : bin_arr) {
				if (i % j == 0) {
					isBin = false;
					break;
				}
			}
			if (isBin) {
				bin_bool[i] = true;
				bin_arr.add(i);
			}
		}
		// 소수배열을 먼저 만들어놓고 해야함.
		dfs(0, nums, 0, 0);
		return answer;
	}


	public static void dfs(int start, int[] nums, int num, int sum) {
		if (num == 3) {
			if (bin_bool[sum])
				answer++;
			return;
		}
		for (int i = start; i < nums.length; i++) {
			dfs(i + 1, nums, num + 1, sum + nums[i]);
		}
	}
}
