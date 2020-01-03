package selftest.java;

public class Company {
	private double salary;
	private double annualIncome;
	private double afterTaxAnnualIncome;
	private double bonus;
	private double afterTaxBonus;

	public Company() {
	}

	public Company(double salary) {
		super();
		this.salary = salary;
	}

	public double getIncome() {
		return salary * 12;
	}

	public double getAfterTaxAnnualIncome() {
		return (salary - salary * 0.1) * 12;
	}

	public double getBonus() {
		return (salary * 0.2) * 4;
	}

	public double getAfterTaxBonus() {
		return getBonus() - getBonus() * 0.055;
	}

}
