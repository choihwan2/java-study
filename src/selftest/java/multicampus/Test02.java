package selftest.java.multicampus;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double input = scanner.nextDouble();
		Company company = new Company(input);
		System.out.printf("연 기본급 합: %.1f 세후 : %.1f%n",company.getIncome(), company.getAfterTaxAnnualIncome());
		System.out.printf("연 보너스 합: %.1f 세후 : %.1f%n",company.getBonus(), company.getAfterTaxBonus());
		System.out.printf("연 지급액 합: %.1f", company.getAfterTaxBonus() + company.getAfterTaxAnnualIncome());
		scanner.close();
	}

}
