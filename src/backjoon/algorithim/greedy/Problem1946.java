package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Problem1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		for (int i = 0; i < test_case; i++) {
			int people_num = Integer.parseInt(br.readLine());

		}
	}

	static class People {
		int p_rank;
		int m_rank;

		public People(int p_rank, int m_rank) {
			super();
			this.p_rank = p_rank;
			this.m_rank = m_rank;
		}

		private static final PeopleCompartor PEOPLE_ORDER = new PeopleCompartor();

		public static class PeopleCompartor implements Comparator<People> {

			@Override
			public int compare(People o1, People o2) {
				return o1.m_rank > o2.m_rank ? o1.p_rank > o2.p_rank ? -100 : 1 : 1;
			}

		}

	}
}
