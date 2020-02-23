package programmers.practice;

public class Country124 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String solution(int n) {
		StringBuilder sb = new StringBuilder();
		int a = 0;
		String[] nara = { "4", "1", "2" };

		while (n != 0) {
			a = n % 3;
			if (a == 0) {
				sb.append("4");
				n = n / 3 - 1;
			} else {
				n = n / 3;
				sb.append(nara[a]);
			}
		}

		return sb.reverse().toString();
	}
}
