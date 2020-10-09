package baekjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10165_버스노선 {

	static class Line implements Comparable<Line> {
		int index;
		int start;
		int last;

		public Line(int index, int start, int last) {
			super();
			this.index = index;
			this.start = start;
			this.last = last;
		}

		@Override
		public int compareTo(Line o) {
			return Integer.compare(this.start, o.start) == 0 ? Integer.compare(o.last, this.last)
					: Integer.compare(this.start, o.start);
		}

		@Override
		public String toString() {
			return "[index=" + index + ", start=" + start + ", last=" + last + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer stk = null;
		LinkedList<Line> normalList = new LinkedList<>(); // 0을 포함하지 않는 리스트 처음점(정렬된상태) 끝점(max). 그 다음에 나오는점이 최대끝점보다 작으면 포함관계
		LinkedList<Line> reverseList = new LinkedList<>(); // a,b  a > b == 0 을 포함하는 리스트
		// 2번째 리스트안에 normal
		for (int i = 1; i <= M; i++) {
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int last = Integer.parseInt(stk.nextToken());

			if (start < last) {
				normalList.add(new Line(i, start, last));
			} else {
				reverseList.add(new Line(i, start, last));
			}
		}

		Collections.sort(normalList);
		Collections.sort(reverseList);

		int maxLast = -1;
		Iterator<Line> it = normalList.iterator();
		while (it.hasNext()) {
			Line line = it.next();
			int l = line.last;
			if (maxLast < l) {
				maxLast = l;
			} else {
				it.remove();
			}
		}

		maxLast = -1;
		int minStart = Integer.MAX_VALUE;
		if (!reverseList.isEmpty()) {
			minStart = reverseList.peekFirst().start;
			Iterator<Line> it2 = reverseList.iterator();
			while (it2.hasNext()) {
				Line line = it2.next();
				int l = line.last;
				if (maxLast < l) {
					maxLast = l;
				} else {
					it2.remove();
				}
			}
		}

		it = normalList.iterator();
		while (it.hasNext()) {
			Line line = it.next();
			if (line.start >= minStart) {
				it.remove();
				continue;
			} else if (line.last <= maxLast) {
				it.remove();
			}
		}

		LinkedList<Line> answerList = new LinkedList<>();
		answerList.addAll(normalList);
		answerList.addAll(reverseList);
		Collections.sort(answerList, new Comparator<Line>() {

			@Override
			public int compare(Line o1, Line o2) {
				return Integer.compare(o1.index, o2.index);
			}
		});
		StringBuilder stb = new StringBuilder();
		for (Line line : answerList) {
			stb.append(line.index).append(" ");
		}
		System.out.println(stb.toString());
	}

}
