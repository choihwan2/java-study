package backjoon.algorithim.string;

import java.util.Scanner;

public class Problem11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int sum = 0;
        scanner.nextLine();
        String str = scanner.nextLine();
        for(int i =0; i<num; i++) {
        	sum += Character.getNumericValue(str.charAt(i));
        }
        System.out.println(sum);
        scanner.close();
	}

}
