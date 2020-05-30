package programmers.school.day01;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class VisitedLength2 {
	private final int[] dx = { 0, 0, -1, 1 }, dy = { 1, -1, 0, 0 };
	private final int MAX = 5, MIN = -5;

	int x = 0, y = 0;

	public int solution(String dirs) {
		int answer = 0;
		Position head = new Position(x, y);
		Position tail = new Position(x, y);
		Set<Path> path = new HashSet<>();

		for (int i = 0; i < dirs.length(); i++) {
			char dir = dirs.charAt(i);
			Position temp = checkGo(changeDir(dir));
			if (temp != null) {
				tail = head;
				head = temp;
				Path temPath = new Path(head, tail);
				Path revPath = new Path(tail, head);
				if (!path.contains(temPath) && !path.contains(revPath)) {
					path.add(temPath);
					path.add(revPath);
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

	private Position checkGo(int dir) {
		int tX = x + dx[dir];
		int tY = y + dy[dir];
		if (tX >= MIN && tX <= MAX && tY >= MIN && tY <= MAX) {
			x = tX;
			y = tY;
			return new Position(tX, tY);
		} else {
			return null;
		}
	}

	private class Position {
		int x;
		int y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			return Objects.hash(this.x,this.y);
		}

		@Override
		public boolean equals(Object obj) {
			Position other = (Position) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (x == other.x && y == other.y)
				return true;
			return false;
		}

		private VisitedLength2 getEnclosingInstance() {
			return VisitedLength2.this;
		}

	}

	private class Path {
		Position nowP;
		Position beforeP;

		public Path(Position nowP, Position beforeP) {
			this.nowP = nowP;
			this.beforeP = beforeP;
		}

		@Override
		public int hashCode() {
			return nowP.hashCode() + beforeP.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			Path other = (Path) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if(nowP.equals(other.nowP) && beforeP.equals(other.beforeP)) {
				return true;
			}
			return false;
		}

		private VisitedLength2 getEnclosingInstance() {
			return VisitedLength2.this;
		}

	}

}
