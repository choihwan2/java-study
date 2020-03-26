package selftest.java.datastructure.recursive;

public class Question3 {

	static int gcdArray(int[] a) {
		int min = 0;
		int max = 0;
		for (int i : a) {
			if (min > i)
				min = i;

			if (max < i)
				max = i;
		}
		return gcd(min, max);
	}

	static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else {
			return gcd(y, x % y);
		}
	}

	public static void main(String[] args) {

	}

}
