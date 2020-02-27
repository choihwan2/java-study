package selftest.java.datastructure.basic;

import java.util.Scanner;

public class Question8 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		System.out.println(solution(num));
		scanner.close();
	}
	
	public static int solution(int num) {
		int answer = 0;
		int start = 1;
		int last = num;
		if(num %2 == 0) {
			answer = (start + last) * num /2;
		}else {
			last = num -1;
			answer = (start + last) * last / 2 + num;
		}
		return answer;
		
	}
}