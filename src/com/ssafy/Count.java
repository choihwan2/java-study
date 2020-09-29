package com.ssafy;

public class Count {
	public static int execute(int N) {
		int value = 1;
		int jumpCnt = 1;
		
		while(value < N) {
			value += jumpCnt++ * 6;
		}
		
		// 구현하세요.		
		return jumpCnt; // 리턴값을 수정하세요
	}

	public static void main(String[] args) {
		int N = 13; 
		System.out.println(Count.execute(N)); // 3
	}

}
