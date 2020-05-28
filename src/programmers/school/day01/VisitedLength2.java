package programmers.school.day01;

import java.util.HashSet;
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
			if (checkGo(changeDir(dir)) != null) {
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
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
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
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + ((beforeP == null) ? 0 : beforeP.hashCode());
			result = prime * result + ((nowP == null) ? 0 : nowP.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Path other = (Path) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (beforeP == null) {
				if (other.beforeP != null)
					return false;
			} else if (!beforeP.equals(other.beforeP))
				return false;
			if (nowP == null) {
				if (other.nowP != null)
					return false;
			} else if (!nowP.equals(other.nowP))
				return false;
			return true;
		}

		private VisitedLength2 getEnclosingInstance() {
			return VisitedLength2.this;
		}
		
		

	}

}
