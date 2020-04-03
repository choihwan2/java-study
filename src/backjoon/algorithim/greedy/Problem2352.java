package backjoon.algorithim.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem2352 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_n = Integer.parseInt(br.readLine());
		Stack<Pipe> work_s = new Stack<>();
		
		StringTokenizer stk = new StringTokenizer(br.readLine());
		while (stk.hasMoreTokens()) {
			int input = Integer.parseInt(stk.nextToken());
			if (work_s.isEmpty()) {
				work_s.add(new Pipe(input));
			}else {
				if (work_s.peek().to < input) {
					for (Pipe pipe : work_s) {
						if(pipe.to < input)
							pipe.go();
					}
				}else {
					work_s.add(new Pipe(input));
				}
			}
		}
		int max = 0;
		for (Pipe pipe : work_s) {
			max = Math.max(max, pipe.canConNum);
		}
		System.out.println(max);
	}

	static class Pipe {
		int to;
		int canConNum;

		public Pipe(int to) {
			this.to = to;
			canConNum = 1;
		}

		public void go() {
			canConNum++;
		}
	}

}
