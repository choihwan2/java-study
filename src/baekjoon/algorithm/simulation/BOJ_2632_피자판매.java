package baekjoon.algorithm.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_2632_피자판매 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pizzaSize = sc.nextInt();
		int m = sc.nextInt();
		int n = sc.nextInt();

		int[] aSize = new int[m];
		int[] bSize = new int[n];

		for (int i = 0; i < m; i++) {
			aSize[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			bSize[i] = sc.nextInt();
		}

		// 누적합을 구하기 위해서 ArrayList를 생성한다
		ArrayList<Integer> aList = new ArrayList<>();
		ArrayList<Integer> bList = new ArrayList<>();

		// 투포인터로 누적합(만들 수 있는 피자 조각의 크기 합을 구하면서 List에 넣어줌
		int low = 0;
		int high = 0;
		int sum = 0;

		while (low < aSize.length) {
			sum += aSize[high++];
			if (sum <= pizzaSize) {
				aList.add(sum);
			} else {
				high = ++low;
				sum = 0;
			}

			// high가 끝을 간 이후 원형이니 다시 처음으로 돌아가기 위한 방법
			high %= m;

			// 계속하다가 둘이 만난경우
			if (low == 0 && high == 0 || high + 1 == low) {
				high = ++low;
				sum = 0;
			}
		}

		low = 0;
		high = 0;
		sum = 0;

		while (low < bSize.length) {
			sum += bSize[high++];

			if (sum <= pizzaSize) {
				bList.add(sum);
			} else {
				high = ++low;
				sum = 0;
			}

			high %= n;

			if (low == 0 && high == 0 || high + 1 == low) {
				high = ++low;
				sum = 0;
			}
		}

		Collections.sort(aList);
		Collections.sort(bList);

		int result = 0;
		int left = 0;
		int right = bList.size() - 1;

		while (left < aList.size() && right >= 0) {
			int lVal = aList.get(left);
			int rVal = bList.get(right);

			int tempSum = lVal + rVal;

			if (tempSum == pizzaSize) {
				int lCnt = 0;
				while (left < aList.size() && aList.get(left) == lVal) {
					lCnt++;
					left++;
				}
				int rCnt = 0;
				while (right >= 0 && bList.get(right) == rVal) {
					rCnt++;
					right--;
				}

				result += lCnt * rCnt;
			}

			if (tempSum < pizzaSize) {
				left++;
			}
			if (tempSum > pizzaSize) {
				right--;
			}
		}

		for (int i = 0; i < aList.size(); i++) {
			if (aList.get(i) == pizzaSize) {
				result++;
			}
		}

		for (int i = 0; i < bList.size(); i++) {
			if (bList.get(i) == pizzaSize) {
				result++;
			}
		}

		System.out.println(result);

	}
}
