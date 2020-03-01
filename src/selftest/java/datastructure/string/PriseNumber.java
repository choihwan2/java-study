package selftest.java.datastructure.string;

public class PriseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test1(); 78022
//		test2(); 14622
		test3();

	}

	public static void test1() {
		int counter = 0;

		for (int n = 2; n <= 1000; n++) {
			int i;
			for (i = 2; i < n; i++) {
				counter++;
				if (n % i == 0)
					break;
			}
			if (n == i) {
				System.out.println(n);
			}
		}
		System.out.println("나눗셈을 수행한 횟수: " + counter);
	}

	public static void test2() {
		int counter = 0;
		int ptr = 0;
		int[] prime = new int[500];

		prime[ptr++] = 2;

		for (int n = 3; n <= 1000; n += 2) {
			int i;
			for (i = 1; i < ptr; i++) {
				counter++;
				if (n % prime[i] == 0)
					break;
			}
			if (ptr == i)
				prime[ptr++] = n;
		}

		for (int i = 0; i < ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("나눗셈을 수행한 횟수: " + counter);
	}

	public static void test3() {
		int counter = 0;
		int ptr = 0;
		int[] prime = new int[500];

		prime[ptr++] = 2;
		prime[ptr++] = 3;

		for (int n = 5; n <= 1000; n += 2) {
			boolean flag = false;
			for (int i = 1; prime[i] * prime[i] <= n; i++) {
				counter +=2;
				if(n % prime[i] ==0) {
					flag = true;
					break;
				}
			}
			
			if(!flag) {
				prime[ptr++] = n;
				counter++;
			}
		}
		
		for(int i =0; i< ptr; i++) {
			System.out.println(prime[i]);
		}
		System.out.println("곱셈과 나눗셈을 수행한 횟수: " + counter); 
	}

}
