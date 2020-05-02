package baekjoon.algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1057 {
	/*
	 * 일단 N명의 참가자는 번호가 1번부터 N번까지 배정받는다. 그러고 난 후에 서로 인접한 번호끼리 스타를 한다. 이긴 사람은 다음 라운드에
	 * 진출하고, 진 사람은 그 라운드에서 떨어진다. 만약 그 라운드의 참가자가 홀수명이라면, 마지막 번호를 가진 참가자는 다음 라운드로 자동
	 * 진출한다. 다음 라운드에선 다시 참가자의 번호를 1번부터 매긴다. 이때, 번호를 매기는 순서는 처음 번호의 순서를 유지하면서 1번부터
	 * 매긴다. 이 말은 1번과 2번이 스타를 해서 1번이 진출하고, 3번과 4번이 스타를 해서 4번이 진출했다면, 4번은 다음 라운드에서 번호
	 * 2번을 배정받는다. 번호를 다시 배정받은 후에 한 명만 남을 때까지 라운드를 계속 한다. 
	 * 
	 * 
	 */
	static int N, kim, yim;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int answer = 0;
		N = Integer.parseInt(input[0]);
		kim = Integer.parseInt(input[1]);
		yim = Integer.parseInt(input[2]);
		while (kim != yim) {
			kim = (kim + 1) / 2;
			yim = (yim + 1) / 2;
			answer++;
		}
		System.out.println(answer);

	}

}
