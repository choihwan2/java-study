package baekjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {

	static int N, d, k, c,temp,answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		d = Integer.parseInt(stk.nextToken());
		k = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		int[] dish = new int[N + k];
		int[] eatNumber = new int[d + 1];
		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
			if(i < k) {
				eatNumber[dish[i]]++;
			}
		}
		int baseNum = answer = getNumber(eatNumber);
		final int MAX = k + 1;
		
		for (int i = N; i < N + k; i++) {
			dish[i] = dish[i - N];
		}
		
		for (int i = k; i < N + k; i++) {
			int delSushi = dish[i-k];
			int addSushi = dish[i];
			
			if(--eatNumber[delSushi] == 0)
				baseNum--;
			if(++eatNumber[addSushi] == 1)
				baseNum++;
			
			int temp = baseNum;
			temp += eatNumber[c] != 0 ? 0 : 1;
			if(temp == MAX) {
				answer = MAX;
				break;
			}
			answer = Math.max(answer, temp);
		}
		System.out.println(answer);
	}
	
	private static int getNumber(int[] eatNumber) {
		int cnt = 0;
		for (int i : eatNumber) {
			if(i > 0)
				cnt++;
		}
		return cnt;
	}
}
