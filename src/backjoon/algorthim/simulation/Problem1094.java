package backjoon.algorthim.simulation;

import java.util.Scanner;

//64 
//32 32 >= 23
//16 16 >= 23
//16 8 8 >= 23
//16 4 4 
//16 4 2 2
//16 4 2 1 1 >= 23
//16 4 2 1
public class Problem1094 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int stick = 64;
		int stick_num = 0;

		while (num > 0) {
			if (num - stick >= 0) {
				num -= stick;
				stick_num++;
			}else {
				stick /=2;
			}
		}

		System.out.println(stick_num);
		scanner.close();
	}
}
