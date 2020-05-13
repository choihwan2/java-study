package programmers.school.day01;

public class MakeBinaryNumber {
	static int[] bin;
	static int[] num_list;
	static int answer;

	public static int solution(int[] nums) {
		answer = 0;
		int[] bin = new int[1500];
		num_list = new int[3];
		
		bin[0] = 2;
		bin[1] = 3;
		
		// 소수배열을 먼저 만들어놓고 해야함.
		
		return answer;
	}

	public static void dfs(int start, int[] nums, int num) {
		if (num == 3) {
			int sum = 0;
			for (int i : num_list) {
				sum += i;
			}
		}

		for (int i = start; i < nums.length; i++) {
			num_list[num] = nums[i];
			dfs(start + 1, nums, num + 1);
		}
	}
}
