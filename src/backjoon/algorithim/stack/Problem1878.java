package backjoon.algorithim.stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Problem1878 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int num  = scanner.nextInt();
		int[] arr_input = new int[num];
		int now_pt = 0;
		Stack<Integer> stack = new Stack<Integer>(); 
		Stack<Integer> wait_s = new Stack<Integer>();
		ArrayList<Character> list = new ArrayList<>();
		for(int i =num; i>0; i++) {
			wait_s.push(num);
		}
		
		for(int i =0; i<num; i++) {
			arr_input[i] = scanner.nextInt();
		}
		
		while(!wait_s.isEmpty()) {
			if(arr_input[now_pt] >= wait_s.peek()) {
				stack.push(wait_s.pop());
				list.add('+');
			}
			
		}
		
		

	}
	
	

}
