package selftest.java.stringtype;

import java.util.StringTokenizer;

public class StringTest01 {

	public static void main(String[] args) {
		String str = "I am second to none";
		int count = 0;
		char[] arrStr = str.toCharArray();
		for (int i = 0; i < arrStr.length; i++) {
			char c = arrStr[i];
			if (c == ' ') {
				count++;
				continue;
			}
			System.out.printf("%s ", c);
		}
		System.out.println("문자개수: " + (arrStr.length - count));
		StringTokenizer stringTokenizer = new StringTokenizer(str);
		System.out.println(stringTokenizer.countTokens());
		while (stringTokenizer.hasMoreTokens()) {
			System.out.print(stringTokenizer.nextToken() + " ");
		}
	}

}
