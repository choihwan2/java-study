package selftest.java.interfaces.page84;

import java.util.Date;

public class DateTest {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		Date date = new Date(2011,8,30);
		ConvertDate(date, 1);
		
	}

	public static String ConvertDate(Date date, int type) {
		String result = "";
		switch (type) {
		case 1:
			System.out.printf("%d-%d-%d", date.getYear(),date.getMonth(),date.getDate());
			break;
		case 2:
			break;
			
		case 3:
			break;
			
		default:
			break;
		}
		return result;
	}

}
