package programmers.kakao.blind2020;

import java.util.StringTokenizer;

public class Solution_5 {
	int[] playTime;
	final int HOUR = 3600, MIN = 60, SEC = 1;

	public String solution(String play_time, String adv_time, String[] logs) {
		String answer = "";
		StringTokenizer stk = new StringTokenizer(play_time, ":");
		int h = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		int s = Integer.parseInt(stk.nextToken());

		playTime = new int[getTime(h, m, s) + 1];

		stk = new StringTokenizer(adv_time, ":");
		h = Integer.parseInt(stk.nextToken());
		m = Integer.parseInt(stk.nextToken());
		s = Integer.parseInt(stk.nextToken());
		int advTime = getTime(h, m, s);

		for (int i = 0; i < logs.length; i++) {
			String[] log = logs[i].split("-");
			stk = new StringTokenizer(log[0], ":");
			h = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			s = Integer.parseInt(stk.nextToken());
			int start = getTime(h, m, s);

			stk = new StringTokenizer(log[1], ":");
			h = Integer.parseInt(stk.nextToken());
			m = Integer.parseInt(stk.nextToken());
			s = Integer.parseInt(stk.nextToken());
			int end = getTime(h, m, s);
			for (int j = start; j < end; j++) {
				playTime[j]++;
			}
		}

		int start = 0;
		int end = advTime;
		int startTime = 0;
		if (end == playTime.length - 1) {
			return "00:00:00";
		}
		long sum = 0;
		for (int i = 0; i < end; i++) {
			sum += playTime[i];
		}
		long max = sum;
		for (int i = end; i < playTime.length; i++) {
			sum += playTime[i] - playTime[start];
			if (max < sum) {
				max = sum;
				startTime = start + 1;
			}
			start++;
		}

		answer = convertTime(startTime);
		System.out.println(answer);

		return answer;
	}

	private int getTime(int h, int m, int s) {
		return h * HOUR + m * MIN + s;
	}

	private String convertTime(int startTime) {
		StringBuilder stb = new StringBuilder();
		int h = startTime / HOUR;
		startTime %= HOUR;
		int m = startTime / MIN;
		startTime %= MIN;
		int s = startTime;
		if (h <= 9) {
			stb.append("0");
		}
		stb.append(h).append(":");

		if (m <= 9) {
			stb.append("0");
		}
		stb.append(m).append(":");

		if (s <= 9) {
			stb.append("0");
		}
		stb.append(s);

		return stb.toString();
	}

	public static void main(String[] args) {
		Solution_5 s = new Solution_5();
		s.solution("02:03:55", "00:14:15", new String[] { "01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29",
				"01:30:59-01:53:29", "01:37:44-02:02:30" });
	}
}
