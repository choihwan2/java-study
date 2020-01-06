package selftest.java.polymorphism;

public class AccountTest {

	public static void main(String[] args) {
		Account account;
		account = new Account("441-0290-1203", 500000.0, 7.3);
		try {
			account.deposit(-10);
		} catch (Exception e) {
			System.out.println("입금 금액이 0보다 작습니다.");
		}
		
		try {
			account.withdraw(600000);
		} catch (Exception e) {
			System.out.println("출금하려는 금액이 0보다 적거나 현재 잔액보다 많습니다.");
		}
		System.out.println(account);
		System.out.printf("이자 :%.1f", account.calculateInterest());
		
		
	}

}
