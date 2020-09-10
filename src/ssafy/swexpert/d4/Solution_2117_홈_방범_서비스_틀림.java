package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2117_홈_방범_서비스_틀림 {
	static int N, M, max;
	static int[] kValue = new int[41];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		kValue[0] = 0;
		kValue[1] = 1;
		for (int i = 2; i < kValue.length; i++) {
			kValue[i] = kValue[i - 1] + 4 * (i - 1);
		}
		for (int t = 1; t <= iT; t++) {
			stk = new StringTokenizer(br.readLine());
			N = Integer.parseInt(stk.nextToken());
			M = Integer.parseInt(stk.nextToken());
			List<int[]> houseList = new ArrayList<>();
			for (int r = 0; r < N; r++) {
				stk = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					int value = Integer.parseInt(stk.nextToken());
					if (value == 1)
						houseList.add(new int[] { r, c });
				}
			}
			int houseSize = houseList.size();

			int[][] distMatrix = new int[houseSize][houseSize];
			for (int i = 0; i < distMatrix.length; i++) {
				int[] from = houseList.get(i);
				for (int j = 0; j < distMatrix.length; j++) {
					if (i == j)
						continue;
					int[] to = houseList.get(j);
					distMatrix[i][j] = Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
				}
			}

			int[][] kList = new int[houseSize][41];

			for (int i = 0; i < houseSize; i++) {
				for (int k = 1; k <= 40; k++) {
					for (int j = 0; j < houseSize; j++) {
						if (distMatrix[i][j] < k)
							kList[i][k] = kList[i][k] + M;
					}
				}
			}
			
			for (int i = 0; i < kList.length; i++) {
				for (int j = 0; j < kList[i].length; j++) {
					if(kList[i][j] >= kValue[j]) {
						int temp = kList[i][j] / M;
						if(max < temp) {
							max = temp;
						}
					}
				}
			}
			System.out.println("#" + t + " " + max);
		} // end Test
	}
}
