package programmers.school.day01;

import java.util.HashSet;
import java.util.Set;

public class VisitedLength2 {
	private final int[] dx = { 0, 0, -1, 1 };
	private final int[] dy = { 1, -1, 0, 0 };
	private final int MAX = 5;
	private final int MIN = -5;

	int x = 0, y = 0;

	public int solution(String dirs) {
		int answer = 0;
		Position head = new Position(x, y);
		Position tail = new Position(x, y);
		Set<Path> path = new HashSet<>();

		for (int i = 0; i < dirs.length(); i++) {
			char dir = dirs.charAt(i);
			if (checkGo(changeDir(dir))) {
				tail = head;
				head = new Position(x, y);
				Path temPath = new Path(head, tail);
				if (!path.contains(temPath)) {
					path.add(temPath);
					answer++;
				}
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

	private boolean checkGo(int dir) {
		int tX = x + dx[dir];
		int tY = y + dy[dir];
		if (tX >= MIN && tX <= MAX && tY >= MIN && tY <= MAX) {
			x = tX;
			y = tY;
			return true;
		} else {
			return false;
		}
	}

	private class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		
		
//		@Override
//		public boolean equals(Object obj) {
//			Position compare = (Position) obj;
//			if (this.x == compare.x && this.y == compare.y) {
//				return true;
//			}
//			return false;
//		}

	}

	private class Path {
		Position nowP;
		Position beforeP;

		public Path(Position nowP, Position beforeP) {
			this.nowP = nowP;
			this.beforeP = beforeP;
		}
		
		
//		@Override
//		public boolean equals(Object obj) {
//			Path compare = (Path) obj;
//			if (this.nowP.equals(compare.nowP) && this.beforeP.equals(compare.beforeP)) {
//				return true;
//			} else if (this.nowP.equals(compare.beforeP) && this.beforeP.equals(compare.nowP)) {
//				return true;
//			}
//			return false;
//		}

	}

}
