package baekjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_7682_틱택토 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, Boolean> answerMap = new HashMap<>();
		String line = "";
		char[][] map = new char[3][3];
		while (!(line = br.readLine()).equals("end")) {
			if (answerMap.containsKey(line)) {
				System.out.println(answerMap.get(line) ? "valid" : "invalid");
				continue;
			}
			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 3; c++) {
					map[r][c] = line.charAt(r * 3 + c);
				}
			}
			boolean answer = checkMap(map);
			answerMap.put(line, answer);
			System.out.println(answer ? "valid" : "invalid");
		}
	}

	private static boolean checkMap(char[][] map) {
		int xCnt = 0;
		int oCnt = 0;

		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (map[r][c] == 'O') {
					oCnt++;
				} else if (map[r][c] == 'X') {
					xCnt++;
				}
			}
		}

		if (xCnt - 1 > oCnt) {
			return false;
		}

		return false;
	}
}
