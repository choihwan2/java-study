package selftest.java.page109;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest01 {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> map2 = new HashMap<>();
		for (int i = 1; i <= 10; i++) {
			map.put(i, (int) (Math.random() * 10));
			map2.put(i, (int) (Math.random() * 10));
		}
		Set<Integer> set = map.keySet();
		Set<Integer> set2 = map.keySet();
		Iterator<Integer> it = set.iterator();
		Iterator<Integer> it2 = set2.iterator();
		System.out.println("맵1\t맵2\t결과");
		while (it.hasNext()) {
			int a = map.get(it.next());
			int b = map2.get(it2.next());
			System.out.print(a + "\t");
			System.out.print(b + "\t");
			try {
				int c = a/b;
				System.out.println(c);
			} catch (Exception e) {
				System.out.println("분모가 0입니다");
				// TODO: handle exception
			}

		}

	}

}
