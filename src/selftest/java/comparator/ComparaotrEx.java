package selftest.java.comparator;

import java.util.Arrays;
import java.util.Comparator;

public class ComparaotrEx {

	public static void main(String[] args) {
		String[] strArr = { "cat", "Dog", "lion", "tiger" };
		
		Arrays.sort(strArr);
		System.out.println("strArr= " + Arrays.toString(strArr));
		
		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
		System.out.println("strArr= " + Arrays.toString(strArr));
		
		Arrays.sort(strArr, new Descending());
		System.out.println("strArr= " + Arrays.toString(strArr));
		
	}

}
class Descending implements Comparator<Comparable<String>>{

	@Override
	public int compare(Comparable<String> o1, Comparable<String> o2) {
		
		return o1.compareTo((String) o2) * -1;
	}
	
}
