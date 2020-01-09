package selftest.java.page102;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {

	public static void main(String[] args) {
		Set<Character> set = new HashSet<Character>();
		char[] arrArgs = args[0].toCharArray();
		for (char c : arrArgs) {
			set.add(c);
		}
		Iterator<Character> it = set.iterator();
		while (it.hasNext()) {
			Character character = (Character) it.next();
			System.out.print(character);
		}
	}

}
