package backjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
// > > >
//

public class Problem2529 {
//	public static void main2(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int num = Integer.parseInt(br.readLine());
//		StringTokenizer stk = new StringTokenizer(br.readLine());
//		int m,n;
//		m = 9;
//		n = 0;
//		Deque<Integer> max_q = new LinkedList<Integer>();
//		Deque<Integer> min_q = new LinkedList<Integer>();
//		
//		max_q.addFirst(m--);
//		min_q.addFirst(n++);
//		while (stk.hasMoreElements()) {
//			String input = stk.nextToken();
//			if (input.equals("<")) {
//				max_q.addFirst(m--);
//				min_q.addLast(n++);
//			}else if (input.equals(">")) {
//				max_q.addLast(m--);
//				min_q.addFirst(n++);
//			}
//		}
//	}
	static int[] n = {0,1,2,3,4,5,6,7,8,9};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		StringBuilder sb_max = new StringBuilder();
		StringBuilder sb_min = new StringBuilder();
		
		Stack<Integer> max_s = new Stack<>();
		Stack<Integer> min_s = new Stack<>();
		int i = 9;
		int j = 0;
		max_s.add(n[i--]);
		min_s.add(n[j++]);
		while (stk.hasMoreTokens()) {
			String next = stk.nextToken();
			if(next.equals("<")) {
				max_s.add(n[i--]);
				while (!min_s.isEmpty()) {
					sb_min.append(min_s.pop());
				}
				min_s.add(n[j++]);
			}else if(next.equals(">")) {
				while (!max_s.isEmpty()) {
					sb_max.append(max_s.pop());
				}
				max_s.add(n[i--]);
				min_s.add(n[j++]);
			}
		}
		
		while (!max_s.isEmpty()) {
			sb_max.append(max_s.pop());
		}
		while (!min_s.isEmpty()) {
			sb_min.append(min_s.pop());
		}
		
		System.out.println(sb_max.toString());
		System.out.println(sb_min.toString());
	}

}
