package programmers.dfsbfs;

public class TargetNumber {
	static int answer = 0;
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		System.out.println(solution(numbers, 1));
	}
	
	public static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0);
		return answer;
	}
	
	public static void dfs(int[] numbers, int target, int k) {
		if(k == numbers.length) {
			int sum = 0;
			for(int i =0; i<numbers.length; i++) {
				sum += numbers[i];
			}
			if(sum == target) {
				answer++;
			}
		}else {
			numbers[k] *= 1;
			dfs(numbers, target, k + 1);
			numbers[k] *= -1;
			dfs(numbers, target, k + 1);
		}
	}

}
