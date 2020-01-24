package programmers.hash;

import java.util.HashMap;

public class Test02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
			String string = phone_book[i];
			hashMap.put(i, string);
		}
        
        for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				if (hashMap.) {
					
				}
			}
		}
        return answer;
    }

}
