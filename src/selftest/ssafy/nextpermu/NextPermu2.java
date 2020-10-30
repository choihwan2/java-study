package selftest.ssafy.nextpermu;

public class NextPermu2 {
	// n C r
	static int[] p = { 0, 0, 1, 1, 1 };
	static int[] a = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {
		do {
			for (int i = 0; i < a.length; i++) {
				if (p[i] == 1) {
					System.out.print(a[i] + " ");
				}
			}
			System.out.println();
		} while (np(p.length - 1));
	}

	static boolean np(int size) {
		int i = size;
		while (i > 0 && p[i - 1] >= p[i])
			i--;
		if (i == 0)
			return false;

		int j = size;
		while (p[i - 1] >= p[j])
			--j;
		swap(i - 1, j);

		int k = size;
		while (i < k) {
			swap(i, k);
			i++;
			k--;
		}

		return true;
	}

	private static void swap(int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
