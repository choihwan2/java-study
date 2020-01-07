package selftest.java.polymorphism;


public class CalcTest {

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		int a = Integer.parseInt(args[0]);
		char operator = args[1].charAt(0);
		int b = Integer.parseInt(args[2]);
		
		switch (operator) {
		case '+':
			System.out.println(calculator.plus(a, b));
			break;
		case '/':
			System.out.println(calculator.divide(a, b));
			break;
		case '-':
			System.out.println(calculator.minus(a, b));
			break;
		case '*':
			System.out.println(calculator.multiplication(a, b));
			break;

		default: 
			break;
		}
		
	}

}
