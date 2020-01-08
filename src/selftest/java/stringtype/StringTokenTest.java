package selftest.java.stringtype;

import java.util.StringTokenizer;

public class StringTokenTest {

	public static void main(String[] args) {

		String str = "4,2,3,6,7";
		int sum = 0;
		StringTokenizer stringTokenizer = new StringTokenizer(str, ",", false);
		while (stringTokenizer.hasMoreTokens()) {
			sum += Integer.parseInt(stringTokenizer.nextToken());
		}
		System.out.println(sum);
	}

}
