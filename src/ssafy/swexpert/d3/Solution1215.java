package ssafy.swexpert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1215 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;

		for (int t = 1; t <= T; t++) {
			br.readLine();
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int[] arr = new int[8];
			for (int i = 0; i < 8; i++) {
				arr[i] = Integer.parseInt(stk.nextToken());

			}
			int ptr = 0;
			aa: while (true) {
				for (int k = 1; k <= 5; k++) {
					arr[ptr] -= k;
					if (arr[ptr] <= 0) {
						arr[ptr] = 0;
						break aa;
					}
					ptr++;
					ptr %= 8;
				}
			}
			System.out.print("#" + t + " ");
			for (int i = ptr + 1; i < 8; i++) {
				System.out.print(arr[i] + " ");
			}
			for (int i = 0; i <= ptr; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}

	}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		for (int t = 1; t <= 10; t++) {
//			Queue<Integer> queue = new LinkedList<Integer>();
//			sc.nextInt();
//			for (int i = 0; i < 8; i++)
//				queue.offer(sc.nextInt());
//			int cnt = 0;
//			while (true) {
//				int p = queue.poll();
//				p -= cnt++ % 5 + 1;
//				
//				if (p <= 0) {
//					queue.offer(0);
//					break;
//				} else {
//					queue.offer(p);
//				}
//			}
//			StringBuilder stb = new StringBuilder();
//			while (!queue.isEmpty()) {
//				stb.append(queue.poll());
//				stb.append(" ");
//			}
//			System.out.println("#" + t + " " + stb.toString());
//		}
//	}
}
