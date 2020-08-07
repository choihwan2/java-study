package com.ssafy.day0722;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine().trim());
		
		int n = Integer.parseInt(st.nextToken());
		st= new StringTokenizer(br.readLine().trim());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		System.out.println(n);
		System.out.println(a);
		System.out.println(b);
	}
}
