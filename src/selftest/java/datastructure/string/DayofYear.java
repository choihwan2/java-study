package selftest.java.datastructure.string;

import java.util.Scanner;

public class DayofYear {

	static int[][] mdays = { { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
			{ 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int retry;

		System.out.println("그 해 경과 일수를 구합니다.");

		do {
			System.out.print("년 : ");
			int year = scanner.nextInt();
			System.out.print("월 : ");
			int month = scanner.nextInt();
			System.out.print("일 : ");
			int day = scanner.nextInt();

			System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
			System.out.printf("남아 있는 날은 %d\n", leftDayOfYear(year, month, day));

			System.out.print("한번 더할까요? (1.예 / 0.아니오) : ");
			retry = scanner.nextInt();
		} while (retry == 1);
		scanner.close();

	}

	public static int isLeap(int year) {
		return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
	}

	public static int dayOfYear(int y, int m, int d) {
		int days = d;
		for (int i = 1; i < m; i++) {
			days += mdays[isLeap(y)][i - 1];
		}
		return days;
	}
	
	public static int dayOfYear2(int y, int m, int d) {
		while(--m != 0) {
			d += mdays[isLeap(y)][m];
		}
		return d;
	}
	
	public static int leftDayOfYear(int y, int m , int d) {
		int leftDay = (isLeap(y) == 1) ? 366 : 365;
		for(int i =1; i< m; i++) {
			leftDay -= mdays[isLeap(y)][i-1];
		}
		return leftDay - d;
	}

}