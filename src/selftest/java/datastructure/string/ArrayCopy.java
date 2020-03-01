package selftest.java.datastructure.string;

public class ArrayCopy {

	public static void main(String[] args) {
		int[][] a = {{1,2,3,4},{5,6,7}};
		int[][] b = new int[2][];
		b[0] = a[0].clone();
		b[1] = a[1].clone();
		
		System.out.println(b[1][2]);
		a[1][2] = 2;
		System.out.println(b[1][2]);
		
	}

}
