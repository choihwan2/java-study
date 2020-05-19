package programmers.school.day01;

import java.util.Arrays;
import java.util.Comparator;

public class MyMindSortString {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.charAt(n) > o2.charAt(n) ? 1
						: o1.charAt(n) < o2.charAt(n) ? -1 : String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
			}
		});
		return strings;
	}
}
