package selftest.java.datastructure.arrays;

import java.util.Scanner;

public class Question6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int no;
		int cd;
		int dno;
		char[] cno = new char[32];
		System.out.println("10진수를 기수 변환합니다.");

		no = scanner.nextInt();
		while (no < 0) {
			System.out.println("입력하신 수가 음수입니다. 다시 입력하세요:");
			no = scanner.nextInt();
		}

		System.out.println("어떤 진수로 변환할까요? (2~36) :");
		cd = scanner.nextInt();
		while (cd < 2 || cd > 36) {
			cd = scanner.nextInt();
		}
		dno = cardConvR(no, cd, cno);
		System.out.print(cd + "진수로는 ");
		for (int i = dno - 1; i >= 0; i--) {
			System.out.print(cno[i]);
		}
		System.out.println("입니다.");
		cardConvPrint(no, cd, cno);
		scanner.close();
	}

	public static int cardConvR(int x, int y, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digits++] = dchar.charAt(x % y);
			x /= y;
		} while (x != 0);
		return digits;
	}

	public static int cardConv(int x, int y, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		do {
			d[digits++] = dchar.charAt(x % y);
			x /= y;
		} while (x != 0);

		for (int i = 0; i < digits / 2; i++) {
			char c = d[i];
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = c;

		}
		return digits;
	}
	public static int cardConvPrint(int x, int y, char[] d) {
		int digits = 0;
		String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		System.out.printf("%d|\t%d\n",y,x);
		System.out.println("+------------");
		do {
			d[digits++] = dchar.charAt(x % y);
			x /= y;
			System.out.printf("%d|\t%d ... %d\n",y,x,x%y);
			System.out.println("+-----------");
		} while (x != 0);
		
		for (int i = 0; i < digits / 2; i++) {
			char c = d[i];
			d[i] = d[digits - i - 1];
			d[digits - i - 1] = c;
		}
		return digits;
	}
}
