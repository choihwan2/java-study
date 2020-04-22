package backjoon.algorithm.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * 문제
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 
 * 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자.
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 
 * 회의의 시작시간과 끝나는 시간이 같을 수도 있다.
 * 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
 * 
 * 입력
 * 첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 
 * 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 
 * 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
 */

public class Problem1931 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input_num = Integer.parseInt(br.readLine());
		ArrayList<Room> room = new ArrayList<>();
		int answer = 0;

		for (int i = 0; i < input_num; i++) {
			String[] input = br.readLine().split(" ");
			room.add(new Room(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
		Collections.sort(room, Room.ROOM_ORDER);

		Room tempRoom = room.get(0);
		answer++;
		for(int i = 1; i< room.size(); i++) {
			if(tempRoom.getEnd_t() <= room.get(i).getStart_t()) {
				tempRoom = room.get(i);
				answer++;
			}
		}
		System.out.println(answer);
	}

	static class Room {
		private int start_t;
		private int end_t;

		public int getStart_t() {
			return start_t;
		}

		public void setStart_t(int start_t) {
			this.start_t = start_t;
		}

		public int getEnd_t() {
			return end_t;
		}

		public void setEnd_t(int end_t) {
			this.end_t = end_t;
		}

		public Room(int s, int l) {
			this.start_t = s;
			this.end_t = l;
		}
		public static final Comparator<Room> ROOM_ORDER = new RoomOrderComparator();

		private static class RoomOrderComparator implements Comparator<Room> {
			@Override
			public int compare(Room o1, Room o2) {
				return o1.end_t > o2.end_t ? 1
						: o1.end_t < o2.end_t ? -1 : o1.start_t > o2.start_t ? 1 : o1.start_t < o2.start_t ? -1 : 0;
			}
		}

	}
}
