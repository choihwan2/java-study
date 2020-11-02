package ssafy.swexpert.prepareA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_5644_무선충전 {
	static class Charger implements Comparable<Charger> {
		int r;
		int c;
		int range;
		int power;
		boolean isUsed = false;

		public Charger(int r, int c, int range, int power) {
			super();
			this.r = r;
			this.c = c;
			this.range = range;
			this.power = power;
		}

		public boolean isInRange(int mR, int mC) {
			int dist = Math.abs(mR - r) + Math.abs(mC - c);
			if (dist <= range) {
				return true;
			} else {
				return false;
			}
		}

		public int getPower() {
			isUsed = true;
			return power;
		}

		public void restore() {
			isUsed = false;
		}

		@Override
		public int compareTo(Charger o) {
			return Integer.compare(o.power, this.power);
		}

		@Override
		public String toString() {
			return "Charger [r=" + r + ", c=" + c + ", range=" + range + ", power=" + power + ", isUsed=" + isUsed
					+ "]";
		}
		
		

	}

	static final int[] dx = { 0, 0, 1, 0, -1 }, dy = { 0, -1, 0, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int t = 1; t <= iT; t++) {
			int M = sc.nextInt();
			int A = sc.nextInt();

			int[] playerA, playerB;
			playerA = new int[M];
			playerB = new int[M];

			for (int i = 0; i < M; i++) {
				playerA[i] = sc.nextInt();
			}

			for (int i = 0; i < M; i++) {
				playerB[i] = sc.nextInt();
			}

			Charger[] chargers = new Charger[A];

			for (int i = 0; i < chargers.length; i++) {
				chargers[i] = new Charger(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			Arrays.sort(chargers);

			int[] posA = { 1, 1 };
			int[] posB = { 10, 10 };
			int sum = getCharge(posA, posB, chargers);
			restore(chargers);

			for (int i = 0; i < M; i++) {
				posA[0] += dx[playerA[i]];
				posA[1] += dy[playerA[i]];

				posB[0] += dx[playerB[i]];
				posB[1] += dy[playerB[i]];

				sum += getCharge(posA, posB, chargers);
				restore(chargers);
			}
			
			System.out.println("#" + t + " " + sum);

		}
	}

	public static int getCharge(int[] a, int[] b, Charger[] chargers) {
		int temp1 = 0;
		int temp2 = 0;
		
		for (int i = 0; i < chargers.length; i++) {
			Charger c = chargers[i];
			if (!c.isUsed && c.isInRange(a[0], a[1])) {
				temp1 += c.getPower();
				break;
			}
		}

		for (int i = 0; i < chargers.length; i++) {
			Charger c = chargers[i];
			if (!c.isUsed && c.isInRange(b[0], b[1])) {
				temp1 += c.getPower();
				break;
			}
		}
		
		restore(chargers);
		
		for (int i = 0; i < chargers.length; i++) {
			Charger c = chargers[i];
			if (!c.isUsed && c.isInRange(b[0], b[1])) {
				temp2 += c.getPower();
				break;
			}
		}

		for (int i = 0; i < chargers.length; i++) {
			Charger c = chargers[i];
			if (!c.isUsed && c.isInRange(a[0], a[1])) {
				temp2 += c.getPower();
				break;
			}
		}
		
		
		// 이제 여기서 서로 가능한 경우를 구한다음 최적을 구해줘야 한다. B가 먼저거나? 아니면 A가 먼저하거

		
		return Math.max(temp1, temp2);
	}
	
	public static void restore(Charger[] chargers) {
		for (int i = 0; i < chargers.length; i++) {
			chargers[i].restore();
		}
	}
}
