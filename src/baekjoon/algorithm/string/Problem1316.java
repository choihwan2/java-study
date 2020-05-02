package baekjoon.algorithm.string;

import java.util.Scanner;

public class Problem1316 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		scanner.nextLine();
		int groupNum = 0;
		for(int i =0; i<num; i++) {
			String str = scanner.nextLine();
			groupNum += solution(str);
		}
		System.out.println(groupNum);
	}
	public static int solution(String a) {
		int[] num = new int[26];
		char c = a.charAt(0);
		
		if(a.length() <= 2) {
			return 1;
		}else {
			for(int i =0; i< a.length(); i++) {
				if(c == a.charAt(i)) {
					num[a.charAt(i)-'a']++;
				}else {
					if(num[a.charAt(i) - 'a'] == -1) {
						return 0;
					}
					num[c - 'a'] = -1;
					c = a.charAt(i);
				}
				a.charAt(i);
			}
		}
		
		return 1;
	}

}
