package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// 먼저 서류나 m_rank로 정렬을 하고 그다음 정렬하지 않읂 것들을 비교해서 작다면 바로 컽
public class Problem1946 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 0; i < test_case; i++) {
			int people_num = Integer.parseInt(br.readLine());
			People[] people = new People[people_num];
			int winner = 1;
			for (int j = 0; j < people.length; j++) {
				String[] input = br.readLine().split(" ");
				people[j] = new People(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}
			Arrays.sort(people, People.PEOPLE_ORDER);
			int top_p = people[0].p_rank;
			for (int p = 1; p < people.length; p++) {
				if (top_p > people[p].p_rank) {
					winner++;
					top_p = people[p].p_rank;
				}
			}
			answer.add(winner);
		}
		for (Integer integer : answer) {
			System.out.println(integer);
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

		@Override
		public String toString() {
			return "People [p_rank=" + p_rank + ", m_rank=" + m_rank + "]";
		}

		public static class PeopleCompartor implements Comparator<People> {

			@Override
			public int compare(People o1, People o2) {
				return o1.m_rank > o2.m_rank ? 1 : -1;
			}
		}
	}
	
	/* 어떤 고수의 문제풀이..
	 *
	 *    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(reader.readLine());
 
        while(tc-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            int [] a= new int[n+1];
 
            for(int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                a[x] = y;
            }
            
            int cnt = 1; //x가 1일때는 무조건 가능하므로 1로 시작
            int standard = a[1]; //기준 값, 처음에는 x가 1일 때의 y값
            for(int i=2; i<=n; i++) {
                if(standard > a[i]) { //기준 값보다 a[i]의 y값이 작다면 
                    cnt++; //추가
                    standard = a[i]; //기준 값 a[i]의 y값으로 변경
                }
            }
            System.out.println(cnt);
        }
    }
	 */
}
