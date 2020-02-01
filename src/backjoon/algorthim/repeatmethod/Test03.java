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
		scanner.close();
	}

	public static void star(int x, int y, int size) {

		if (size == 1) {
			stars[x][y] = '*';
			return;
		}
		int temp = size / 3;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(i == 1 && j == 1)continue;
				star(x + i * temp, y + j * temp , temp);
			}
		}

	}

}
