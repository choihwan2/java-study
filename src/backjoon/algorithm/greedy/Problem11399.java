package backjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Problem11399 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer input = new StringTokenizer(bf.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(input.nextToken()); 
		}
		Arrays.sort(arr);
		int sum = 0;
		int temp = 0;
		for (int i : arr) {
			temp += i;
			sum += temp;
		}
		
		System.out.println(sum);
		
	}
}
