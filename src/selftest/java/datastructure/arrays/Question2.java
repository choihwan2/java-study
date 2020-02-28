package selftest.java.datastructure.arrays;

import java.util.Arrays;

public class Question2 {

	public static void main(String[] args) {
		int[] a = { 5, 10, 63, 2, -5, 42, 3 };
		for (int i = 0; i < a.length / 2; i++) {
			System.out.println(Arrays.toString(a));
			swap(a, i, a.length - i - 1);
		}
		System.out.println(Arrays.toString(a));
		System.out.println("정렬을 끝마쳤습니다.");

	}

	public static void swap(int[] a, int fdx, int ldx) {
		int temp = a[fdx];
		a[fdx] = a[ldx];
		a[ldx] = temp;
		System.out.printf("a[%d]과(와) a[%d]를 교환합니다.\n", fdx, ldx);
	}

	public static int sumOf(int[] a) {
		int sum = 0;
		for (int i : a) {
			sum += i;
		}
		return sum;
	}

}
