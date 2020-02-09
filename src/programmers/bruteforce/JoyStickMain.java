package programmers.bruteforce;

import java.util.Arrays;

public class JoyStickMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	//1. 문자 배열중 선택하여 값을 비교한다.
	//2. 다르면 위로 올리는 것이나 아래로 내리는 것중 맞춰준다음 가장 적은 횟수가 드는 것으로 선택
	//3. 문자열이 같은지 확인한다.
	//4. 왼쪽으로 갈때와 오른쪽으로 갈때 가장 빠르게 다른값을 가질때를 찾는다. 

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
