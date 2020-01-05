package selftest.java.polymorphism;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {

		Calc calc = new Calc();
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력 값:");
		while (true) {
			int input = scanner.nextInt();
			scanner.nextLine();
			if (input < 5 || input > 10) {
				System.out.println("다시 입력하세요.");
			}else {
				System.out.print("결과: ");
				System.out.println(calc.calculate(input));
				break;
			}
		}
		scanner.close();
	}

}
