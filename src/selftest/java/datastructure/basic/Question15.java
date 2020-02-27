package selftest.java.datastructure.basic;

public class Question15 {
	public static void main(String[] args) {
		triangleLB(5);
		System.out.println();
		triangleLU(5);
		System.out.println();
		triangleRB(5);
		System.out.println();
		triangleRU(5);
		System.out.println();
		spira(5);
		npira(11);
	}

	public static void triangleLB(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void triangleRB(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				System.out.print(" ");
			}
			for (int z = 0; z <= i; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void triangleLU(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			for (int z = 0; z < i; z++) {
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void triangleRU(int n) {
		for (int i = 0; i < n; i++) {
			for (int z = 0; z < i; z++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n - i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void spira(int n) {
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < n - i -1; j++) {
				System.out.print(" ");
			}
			for(int z = 0; z < 2*i + 1; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void npira(int n) {
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < n - i -1; j++) {
				System.out.print(" ");
			}
			for(int z = 0; z < 2*i + 1; z++) {
				System.out.print((i+1) % 10);
			}
			System.out.println();
		}
	}

}
