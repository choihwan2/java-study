package programmers.school.day04;

public class Tile2X {

	/*
	 * 1 => 1 2 => 2 3 => 3 4 => 5 5 => 8 6 => 13
	 * 
	 */
	public int solution(int n) {
		int[] nList = new int[n + 1];
		nList[0] = 0;
		nList[1] = 1;
		nList[2] = 2;
		for (int i = 3; i <= n; i++) {
			nList[i] = (nList[i - 2] + nList[i - 1]) % 1000000007;
		}
		int answer = nList[n];
		return answer;
	}

}
