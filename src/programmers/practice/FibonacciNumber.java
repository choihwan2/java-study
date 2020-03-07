package programmers.practice;

public class FibonacciNumber {
	  public int solution(int n) {
	      int answer = 0;
	      answer = f(n);
	      return answer;
	  }
	    
	    public static int f(int n){
	        int[] fib_arr = new int[n+2];
	        fib_arr[0] = 0;
	        fib_arr[1] = 1;
	        if (n == 0 || n== 1)
	            return fib_arr[n];
	        for(int i = 2; i<=n; i++){
	            fib_arr[i] = (fib_arr[i-2] + fib_arr[i-1]) % 1234567;
	        }
	        return fib_arr[n];
	    }
	}
