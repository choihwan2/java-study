package com.ssafy.day0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution4408_CombackMyRoom {
	private static class Room implements Comparable<Room> {
		int from;
		int to;

		public Room(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}

		@Override
		public int compareTo(Room o) {
			return Integer.compare(this.to, o.to);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = null;
		PriorityQueue<Room> pq = new PriorityQueue<>();
		int iT = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= iT; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] roomArr = new int[401];
			for (int i = 0; i < N; i++) {
				stk = new StringTokenizer(br.readLine().trim());
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				int temp = 0;
				temp = Math.min(from, to);
				to = Math.max(from, to);
				from = temp;
				pq.add(new Room(from, to));
			}
			while (!pq.isEmpty()) {
				Room now = pq.poll();
				now.to = now.to % 2 == 0 ? now.to : now.to + 1;
				for (int i = now.from; i <= now.to; i++) {
					roomArr[i]++;
				}
			}
			int answer = 0;
			for (int i = 1; i < roomArr.length; i++) {
				if (answer < roomArr[i])
					answer = roomArr[i];
			}
			System.out.println("#" + t + " " + answer);
		}

	}
}
