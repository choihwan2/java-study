package baekjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Problem1969_2 {

	static final char[] D = { 'A', 'C', 'G', 'T' };
	static int[][] N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int num = Integer.parseInt(input[0]);		// 문자열을 몇개 받는지 저장하는 num
		int length = Integer.parseInt(input[1]);	// 문자열의 길이 length
	
		String[] arr = new String[num];
		for (int i = 0; i < num; i++) {
			arr[i] = br.readLine();
		}							// 쭉 넣어준다.
		N = new int[length][4];		// 문자열 길이만큼 2차원 배열을 갖는다.
		StringBuilder stb = new StringBuilder();
		
		for(int i = 0; i< num; i++) {
			calString(arr[i]);
		}

		for (int i = 0; i < length; i++) {
			char a = makeAlpha(N[i]);
			stb.append(a);
		}
		System.out.println(stb.toString());
		System.out.println(calDiff(arr, stb.toString()));
	}

	public static void calString(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'A') {
				N[i][0]++;
			} else if (str.charAt(i) == 'C') {
				N[i][1]++;
			} else if (str.charAt(i) == 'G') {
				N[i][2]++;
			} else if (str.charAt(i) == 'T') {
				N[i][3]++;
			}
		}
	}

	public static char makeAlpha(int[] num_arr) {
		int index = 0;
		int max = 0;
		for (int i = 0; i < num_arr.length; i++) {
			if (max < num_arr[i]) {
				max = num_arr[i];
				index = i;
			}
		}
		return D[index];
	}

	public static int calDiff(String[] arr, String hdString) {
		int answer = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) != hdString.charAt(j))
					answer++;
			}
		}

		return answer;
	}

}
