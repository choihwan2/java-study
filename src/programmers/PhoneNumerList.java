package programmers;

public class PhoneNumerList {

	public static void main(String[] args) {
		String a = "1195524421";
		StringBuffer sf = new StringBuffer("119");
		String[] bStrings = { "119", "97674223", "1195524421" };
		System.out.println(solution2(bStrings));
	}

	public static boolean solution(String[] phone_book) {
		boolean answer = true;
		for (int i = 0; i < phone_book.length; i++) {
			if (phone_book.length == 1) {
				return false;
			}
			for (int j = 0; j < phone_book.length; j++) {
				if (i != j) {
					if (phone_book[j].contains(new StringBuffer(phone_book[i])))
						return false;
				}
			}
		}
		return answer;
	}
	
	public static boolean solution2(String[] phone_book) {
		boolean answer = true;
		for (int i = 0; i < phone_book.length; i++) {
			if (phone_book.length == 1) {
				return false;
			}
			for (int j = 0; j < phone_book.length; j++) {
				if (i != j) {
					if (phone_book[i].startsWith(phone_book[j]))
						return false;
				}
			}
		}
		return answer;
	}

}
