package selftest.java.stringtype;

import java.text.DecimalFormat;

public class StringTest03 {
	public static void main(String[] args) {
		DecimalFormat format = new DecimalFormat("###,###");
		String numberString = "300000000000";
		System.out.println(format.format(Long.parseLong(numberString)));
		System.out.println(convert(numberString));

	}

	public static String convert(String str) {
		String result = "";
		char[] chars = str.toCharArray();
		int j = 1;
		for (int i = chars.length - 1; i >= 0; i--) {
			if (j % 3 == 0) {
				if (i == 0) {
					result = chars[i] + result;
				} else {
					result = "," + chars[i] + result;
				}
			} else {
				result = chars[i] + result;
			}
			j++;
		}
		return result;
	}
}
