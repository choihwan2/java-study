package com.ssafy.prepare.im;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2116_주사위쌓기 {
	static int[] dx = { 5, 3, 4, 1, 2, 0 },dice[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		int max = 0;
		int N = Integer.parseInt(br.readLine());
		dice = new int[N][6];
		boolean[][] isSelected;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 6; j++) {
				dice[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
		
		for (int i = 0; i < 6; i++) {
			isSelected = new boolean[N][6];
			isSelected[0][i] = true;
			isSelected[0][dx[i]] = true;
			int next = dice[0][dx[i]];
			for (int j = 1; j < N; j++) {
				next = findNext(isSelected,next,j);
			}
			int temp = getSum(isSelected);
			
			if(max < temp) {
				max = temp;
			}
		}
		System.out.println(max);
	}

	private static int findNext(boolean[][] isSelected, int first, int j) {
		int[] row = dice[j];
		int next = 0;
		for (int i = 0; i < row.length; i++) {
			if(row[i] == first) {
				isSelected[j][i] = true;
				isSelected[j][dx[i]] = true;
				next = row[dx[i]];
				break;
			}
		}
		return next;
	}
	
	private static int getSum(boolean[][] isSelected) {
		int sum = 0;
		for (int i = 0; i < dice.length; i++) {
			int temp = 0;
			for (int j = 0; j < dice[i].length; j++) {
				if(isSelected[i][j]) continue;
				
				if(temp < dice[i][j]) {
					temp = dice[i][j];
				}
			}
			sum +=temp;
		}
		
		return sum;
	}
}
