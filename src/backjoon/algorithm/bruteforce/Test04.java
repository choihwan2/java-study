package backjoon.algorithm.bruteforce;

import java.util.*;

public class Test04{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(solution(x));
        scanner.close();
    }
    
    public static String solution(int num){
    	int N = num;
    	Integer temp = 0;
    	while (N > 0) {
			temp++;
			if(temp.toString().contains("666")) {
				N--;
			}
		}
        return temp.toString();
    }
}

