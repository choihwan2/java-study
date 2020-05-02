package baekjoon.algorithm.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Problem11866 {
	/*
	 * 요세푸스 문제는 다음과 같다.
	 * 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 
	 * 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 
	 * 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 
	 * 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 
	 * 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 
	 * 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.
	 * N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strToken = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(strToken.nextToken());
		int K = Integer.parseInt(strToken.nextToken());
		int cnt = 0;
		
		Queue<Integer> que = new LinkedList<Integer>();
		Queue<Integer> wait_que = new LinkedList<Integer>();
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for (int i = 1; i <= N; i++) {
			que.add(i);
		}
		
		while (!que.isEmpty()) {
			cnt++;
			if(cnt != K) {
				wait_que.add(que.poll());
			}else {
				answer.add(que.poll());
				cnt -= K;
			}
			if (!wait_que.isEmpty()) {
				que.add(wait_que.poll());
			}
		}
		StringBuilder str = new StringBuilder();
		str.append("<");
		for (int i = 0; i < answer.size(); i++) {
			if(i != answer.size() -1) {	
				str.append(answer.get(i));
				str.append(", ");
			}else {
				str.append(answer.get(i));
			}
		}
		str.append(">");
		System.out.println(str.toString());
	}

}
