package backjoon.algorthim.repeatmethod;

import java.util.Arrays;
import java.util.Scanner;

public class Test03 {

	static char stars[][];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		stars = new char[num][num];
		for (int i = 0; i < stars.length; i++) {
			Arrays.fill(stars[i], ' ');
		}
		star(0, 0, num);
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < stars.length; i++) {
			for (int j = 0; j < stars[i].length; j++) {
				stringBuffer.append(stars[i][j]);
			}
			stringBuffer.append("\n");
		}
		System.out.println(stringBuffer.toString());
	}

	public static void star(int x, int y, int size) {

		if(size == 1) {
			stars[x][y] = '*';
			return;
		}
		
		star(x, y, size / 3);
		star(x, y + size / 3, size / 3);
		star(x, y + size / 3 * 2, size / 3);

		star(x + size / 3, y, size / 3);
		star(x + size / 3, y + size / 3 * 2, size / 3);

		star(x + size / 3 * 2, y, size / 3);
		star(x + size / 3 * 2, y + size / 3, size / 3);
		star(x + size / 3 * 2, y + size / 3 * 2, size / 3);
	}

}
