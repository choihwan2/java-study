package programmers.school.day01;

import java.util.HashSet;

public class VisitedLength {
	private final int[] dx = { 0, 0, -1, 1 };
	private final int[] dy = { 1, -1, 0, 0 };
	private final int size = 10;
	public int solution(String dirs) {
		int answer = 0;
		int x = 5, y = 5;

		HashSet<String> visitSet = new HashSet<>();
		for (int i = 0; i < dirs.length(); i++) {
			int dir = changeDir(dirs.charAt(i));
			int tX = x + dx[dir];
			int tY = y + dy[dir];

			if (tX >= 0 && tX <= size && tY >= 0 && tY <= size) { // Map 의 범위 내일때
				String line = makeLine2(x, y, tX, tY);
				String revLine = makeLine2(tX, tY, x, y);
				if(!visitSet.contains(line) && !visitSet.contains(revLine)) {
					visitSet.add(line);
					visitSet.add(revLine);
					answer++;
				}
				x = tX;
				y = tY;
			}
		}
		return answer;
	}

	private int changeDir(char dir) {
		if (dir == 'U') {
			return 0;
		} else if (dir == 'D') {
			return 1;
		} else if (dir == 'L') {
			return 2;
		} else {
			return 3;
		}
	}

//	private int makeLine(int x, int y, int tX, int tY) {
//		int line = 1000 * x + 100 * y + 10 * tX + tY;
//		return line;
//	}
	
	private String makeLine2(int x, int y, int tX, int tY) {
		StringBuilder stb = new StringBuilder();
		stb.append(x);
		stb.append(y);
		stb.append(tX);
		stb.append(tY);
		
		return stb.toString();
	}
}
