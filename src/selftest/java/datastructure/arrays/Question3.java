package selftest.java.datastructure.arrays;

import java.util.Arrays;

public class Question3 {
	public static void main(String[] args) {
		int[] b = {1,2,3};
		int[] a = new int[b.length];
		copy(a, b);
		rcopy(a, b);
		
		System.out.println(Arrays.toString(a));
		
	}

	public static void copy(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			a[i] = b[i];
		}
	}

	public static void rcopy(int[] a, int[] b) {
		for (int i = 0; i < b.length; i++) {
			a[i] = b[b.length - i - 1];
		}
	}

}
