package selftest.java.interfaces.page84;

public class StringBufferTest {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("LGCNS");
		String str = null;
		str = "cnser";
		sb.replace(2, 5, str);
		System.out.println(sb.toString());
	}

}
