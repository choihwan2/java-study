package backjoon.algorithim.string;

import java.util.Scanner;

public class Problem10809 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1 };

		String str = scanner.nextLine();
		for (int i = 0; i < str.length(); i++) {
			if (a[(int) (str.charAt(i) - 'a')] == -1) {
				a[(int) (str.charAt(i) - 'a')] = i;
			}
		}
		
		for(int i =0; i< a.length; i++) {
			System.out.printf("%d ",a[i]);
		}
	}
}
