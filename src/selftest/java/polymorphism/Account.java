package selftest.java.polymorphism;

public class Account {
	private String account;
	private double balance;
	private double interestRate;

	public Account() {
	}

	public Account(String account, double balance, double interestRate) {
		super();
		this.account = account;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	public double calculateInterest() {
		return balance * interestRate / 100;
	}

	public void deposit(double money) throws Exception {
		if (money < 0) {
			throw new Exception();
		} else {
			balance += money;
		}
	}

	public void withdraw(double money) throws Exception {
		if (money < 0 || money > balance) {
			throw new Exception();
		} else {
			balance -= money;
		}
	}

	@Override
	public String toString() {
		return "Account [account=" + account + ", balance=" + balance + ", interestRate=" + interestRate + "]";
	}
	

}
