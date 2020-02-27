package selftest.java.datastructure.basic;

public class Question9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sumof(6, 4));

	}

	public static int sumof(int a, int b) {
		int sum = 0;
		if (a >= b) {
			for (int i = b; i <= a; i++) {
				sum += i;
			}
		} else {
			for (int i = a; i <= b; i++) {
				sum += i;
			}
		}
		return sum;
	}

}
