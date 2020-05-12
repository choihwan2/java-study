package programmers.school.day01;

public class HashardNumber {
	public boolean solution(int x) {
		String num_x = String.valueOf(x);
		int sum = 0;
		for (int i = 0; i < num_x.length(); i++) {
			sum += Character.getNumericValue(num_x.charAt(i));
		}
		return x % sum == 0 ? true : false;
	}
}
