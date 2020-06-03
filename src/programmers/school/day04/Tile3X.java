package programmers.school.day04;

public class Tile3X {
	// 0 => 0
	// 1 => 0
	// 2 => 3
	// 3 => 0
	// 4 => 11
	// 5 => 0
	// 6 =>
	public int solution(int n) {
		int[] nList = new int[n + 2];
		nList[2] = 3;
		nList[4] = 11;

		for (int i = 6; i < n + 1; i += 2) {
			if (i % 4 == 0) {
				nList[i] = ((nList[i - 4] * 2) + (nList[i - 2] * 3)) % 1000000007;
			} else if (i % 2 == 0) {
				nList[i] = (nList[i - 2] * 3 + 2) % 1000000007;
			}
		}
		return nList[n];
	}
}
