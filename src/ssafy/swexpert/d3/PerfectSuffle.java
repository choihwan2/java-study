package ssafy.swexpert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class PerfectSuffle {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int iT = Integer.parseInt(br.readLine());
		for (int t = 1; t <= iT; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			Queue<String> firstQueue = new LinkedList<String>();
			Queue<String> secondQueue = new LinkedList<String>();

			for (int i = 0; i < (n % 2 == 0 ? n / 2 : n / 2 + 1); i++) {
				firstQueue.offer(stk.nextToken());
			}
			for (int i = 0; i < n / 2; i++) {
				secondQueue.offer(stk.nextToken());
			}
			StringBuilder stb = new StringBuilder();

			while (!firstQueue.isEmpty() && !secondQueue.isEmpty()) {
				stb.append(firstQueue.poll());
				stb.append(" ");
				stb.append(secondQueue.poll());
				stb.append(" ");
			}
			if (!firstQueue.isEmpty()) {
				stb.append(firstQueue.poll());
			}
			System.out.println("#" + t + " " + stb.toString());
		}
	}

}
