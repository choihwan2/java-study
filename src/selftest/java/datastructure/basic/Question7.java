package selftest.java.datastructure.basic;

import java.util.Scanner;

public class Question7 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		solution(num);
		scanner.close();
	}
	
	public static void solution(int num) {
		StringBuilder builder = new StringBuilder();
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			builder.append(i);
			sum += i;
			if(i!= num) {	
				builder.append(" + ");
			}else {
				builder.append(" = ");
				builder.append(sum);
			}
		}
		System.out.println(builder.toString());
	}
}
