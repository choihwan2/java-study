package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 2칸 위로, 1칸 오른쪽
1칸 위로, 2칸 오른쪽
1칸 아래로, 2칸 오른쪽
2칸 아래로, 1칸 오른쪽

y >=3일때

x a
1 1
2 2
3 3
4 4
5 4
6 4
7 5
8 6
9 7
10 8
14 12
18 16
22 20


 */
public class Problem1783 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int height = Integer.parseInt(input[0]);
		int width = Integer.parseInt(input[1]);
		System.out.println(move(height, width));
	}

	public static int move(int height, int width) {
		int answer = 1;
		if (height <= 1)
			return 1;
		if (height == 2) {
			if (width >= 4)
				return width <= 8 ? width / 2 : 4;
			else {
				return 1;
			}
		}
		if (height >= 3) {
			if (width <= 4) {
				return width;
			}
			if (width <= 6) {
				return 4;
			} else {
				return width - 2;
			}

		}

		return answer;
	}
}
