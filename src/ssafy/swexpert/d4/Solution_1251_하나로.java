package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {

	private static class Island {
		int x;
		int y;

		public Island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public double getDistance(Island o) {
			return Math.sqrt(Math.pow(Math.abs(o.x - this.x), 2) + Math.pow(Math.abs(o.y - this.y), 2)) ;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk1 = null;
		StringTokenizer stk2 = null;
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			int N = Integer.parseInt(br.readLine());
			Island[] island = new Island[N];
			boolean[] isSelected = new boolean[N];
			double[] distance = new double[N];
			stk1 = new StringTokenizer(br.readLine());
			stk2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				island[i] = new Island(Integer.parseInt(stk1.nextToken()), Integer.parseInt(stk2.nextToken()));
			}
			double E = Double.parseDouble(br.readLine());
			
			int minVertex;
			double min, result = 0;
			Arrays.fill(distance,Double.MAX_VALUE);
			distance[0] = 0;

			for (int c = 0; c < N; c++) {
				min = Double.MAX_VALUE;
				minVertex = 0;

				for (int i = 0; i < N; ++i) {
					if (!isSelected[i] && distance[i] < min) {
						min = distance[i];
						minVertex = i;
					}
				}

				result += Math.pow(min,2) * E;
				isSelected[minVertex] = true;

				for (int j = 0; j < N; j++) {
					if (!isSelected[j] && island[minVertex].getDistance(island[j]) < distance[j]) {
						distance[j] = island[minVertex].getDistance(island[j]);
					}
				}
			}
			System.out.print("#" + t + " ");
			System.out.println(Math.round(result));
			
		} //  test End
	}

}
