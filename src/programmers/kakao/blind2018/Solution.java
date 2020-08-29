package programmers.kakao.blind2018;

import java.util.Arrays;

class Solution {
	static int weakLen;
	static int distLen;
	static int N;
	static int[] allWeak;
	static int[] dist;
	static int minVal = Integer.MAX_VALUE;

	public int solution(int n, int[] weak, int[] d) {
		N = n;
		dist = d;
		weakLen = weak.length;
		distLen = dist.length;

		int[] clock = Arrays.stream(weak).map(c -> c + n).toArray();
		int[] counterClock = Arrays.stream(weak).map(c -> c - n).toArray();

		allWeak = new int[3 * weakLen];
		for (int i = 0; i < weakLen; i++) {
			allWeak[i] = counterClock[i];
		}
		for (int i = weakLen; i < 2 * weakLen; i++) {
			allWeak[i] = weak[i - weakLen];
		}
		for (int i = 2 * weakLen; i < 3 * weakLen; i++) {
			allWeak[i] = clock[i - 2 * weakLen];
		}

		Arrays.sort(dist);

		for (int i = 0; i < weakLen; i++) {
			int curPos = i + weakLen;
			int curFriend = distLen - 1;
			rightRotate(curPos, curPos + weakLen - 1, curFriend);
			leftRotate(curPos - weakLen + 1, curPos, curFriend);
		}
		return (minVal <= distLen ? minVal : -1);

	}

	private static void leftRotate(int leftEnd, int rightEnd, int curFriend) {

		if (leftEnd > rightEnd) {
			minVal = Math.min(minVal, distLen - curFriend - 1);
			return;
		}
		if (curFriend < 0)
			return;
		int lower = allWeak[rightEnd] - dist[curFriend];
		int cnt = 0;
		for (int i = 0; i <= rightEnd - leftEnd; i++) {
			if (allWeak[rightEnd - i] >= lower) {
				cnt++;
			} else {
				break;
			}
		}
		rightRotate(leftEnd, rightEnd - cnt, curFriend - 1);
		leftRotate(leftEnd, rightEnd - cnt, curFriend - 1);

	}

	private static void rightRotate(int leftEnd, int rightEnd, int curFriend) {

		if (leftEnd > rightEnd) {
			minVal = Math.min(minVal, distLen - curFriend - 1);
			return;
		}
		if (curFriend < 0)
			return;
		int upper = allWeak[leftEnd] + dist[curFriend];
		int cnt = 0;
		for (int i = 0; i <= rightEnd - leftEnd; i++) {
			if (allWeak[leftEnd + i] <= upper) {
				cnt++;
			} else {
				break;
			}
		}
		rightRotate(leftEnd + cnt, rightEnd, curFriend - 1);
		leftRotate(leftEnd + cnt, rightEnd, curFriend - 1);

	}

}