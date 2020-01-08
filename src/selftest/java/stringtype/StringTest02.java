package selftest.java.stringtype;

public class StringTest02 {

	public static void main(String[] args) {
		String str = "    [Beyond Promise.]    ";
//		char[] arrStr = str.toCharArray();
//		StringBuilder builder = new StringBuilder();
//		for (int i = 0; i < arrStr.length; i++) {
//			char c = arrStr[i];
//			if(c == ' ') {
//				arrStr[i] = '_'; 
//			}
//			builder.append(arrStr[i]);
//		}
		System.out.println(str.replace(' ', '_'));
		System.out.println(str.trim());
		System.out.println(str.trim().toUpperCase());
		System.out.println(str.trim().toLowerCase());
		System.out.println(str.trim().replace('e', 'a'));
		System.out.println(str.trim().substring(8, 15));
		
	}

}
