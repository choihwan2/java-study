package programmers.perfectsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FindDemicalNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		int answer = 0;
		int[] cnt_arr = new int[10];

		ArrayList<Integer> demiList = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); i++) {
			cnt_arr[(input.charAt(i)) - '0']++;
		}

		int max_demi = findMaxNum(cnt_arr);
		demiList.add(2);
		demiList.add(3);
		for (int i = 5; i <= max_demi; i += 2) {
			boolean flag = true;
			for (int j = 0; j < Math.sqrt(demiList.size()); j++) {
				if (i % demiList.get(j) == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				demiList.add(i);
			}
		}
		for (Integer integer : demiList) {
			answer += isCanMake(integer, cnt_arr);
		}
		System.out.println(answer);

	}

	public static int findMaxNum(int[] cnt_arr) {
		int answer = 0;
		StringBuilder str = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			for (int j = 0; j < cnt_arr[i]; j++) {
				str.append(i);
			}
		}
		answer = Integer.parseInt(str.toString());
		return answer;
	}

	public static int isCanMake(int num, int[] cnt_arr) {
		int answer = 1;
		int[] temp = cnt_arr.clone();
		String a = Integer.toString(num);
		for (int i = 0; i < a.length(); i++) {
			temp[Character.getNumericValue(a.charAt(i))]--;
		}

		for (int j = 0; j < 10; j++) {
			if (temp[j] < 0) {
				return 0;
			}
		}
		return answer;
	}

}
