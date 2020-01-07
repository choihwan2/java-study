package selftest.java.interfaces.page84;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("LGCNS");
		String str = null;
		str = "null";
		sb.replace(2, 3, "c");
		sb.replace(3, 4, "n");
		sb.replace(4, 5, "s");
		sb.append("er");
		str = sb.toString();
		System.out.println(str.toString());
	}

}
