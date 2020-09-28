package ssafy.swexpert.d3;

import java.util.Scanner;

public class Solution_5607_조합 {
	static final int DIV = 1234567891;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[] fact = new long[1000001];
		init(fact);
		int iT = sc.nextInt();
		for (int i = 1; i <= iT; i++) {
			int N = sc.nextInt();
			int R = sc.nextInt();
			long first = fact[N];
			
			long denominator = (fact[R] * fact[N-R])%DIV;
			
			long index = DIV-2;
			long fermatNum = 1;
			while(index> 0) {
				if(index %2 == 1) {
					fermatNum *= denominator;
					fermatNum %= DIV;
				}
				denominator = (denominator * denominator) %DIV;
				index /=2;
			}
			
			
			long answer = (first * fermatNum) % DIV;
			System.out.println("#" + i + " " + answer);
			
		}

	}

	private static void init(long[] fact) {
		fact[0] = 0;
		fact[1] = 1;
		for (int i = 2; i < fact.length; i++) {
			fact[i] = (fact[i-1] * i) % DIV;
		}
	}
	
    public static long calcPow(long a, long n){
        if(n == 0){
            return 1;
        }else{
            long temp = calcPow(a, n/2);
            if(n%2 == 0) return temp*temp % DIV;
            else return temp*temp*a % DIV;
        }
    }

}
