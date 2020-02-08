package programmers.bruteforce;

import java.util.Arrays;

public class JoyStickMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public static int solution(String name) {
		int answer = 0;
		char[] arr_name = name.toCharArray();
		char[] basic = new char[arr_name.length];
		Arrays.fill(basic, 'A');
		return answer;
	}

	public static int up(char goal) {
		int cnt = 0;
		char c = 'A';
		while (c != goal) {
			c++;
			cnt++;
		}
		return cnt;
	}

	public static int down(char goal) {
		int cnt = 0;
		char c = 'A';
		while (c != goal) {
			if (c == 'A') {
				c = 'Z';
				cnt++;
				continue;
			}
			c--;
			cnt++;
		}
		return cnt;
	}
	
	public static int right(char[] goal) {
		int cnt = 0;
		for (char c : goal) {
			cnt += Math.min(up(c), down(c));
			cnt++;
		}
		
		return cnt;
	}

}
