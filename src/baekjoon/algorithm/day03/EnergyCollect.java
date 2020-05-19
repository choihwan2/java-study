package baekjoon.algorithm.day03;

import java.util.LinkedList;
import java.util.Scanner;

public class EnergyCollect {
	
	/*
	 * 아예 잘못접근했다. 연결리스트로 최대가 값을 찾아서 곱해준다음 계속해서 나아가려 했지만...
	 * 같은 값이 있을 경우 둘중에 뭘선택해야지 최선인지 알 수 없기때문이다. 후에 인덱스의 값이 어떻게 영향을 미칠지 모르니깐..
	 * 결론적으로 모든 결과를 구한후에 비교해줘야하는 브루트포스의 해결법으로 풀어야한다. 
	 */

	static int max;
	static int index;
	static int energySum = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> energyList = new LinkedList<>();
		int N = scanner.nextInt();
		for (int i = 0; i < N; i++) {
			energyList.add(scanner.nextInt());
		}
		while (energyList.size() >= 3) {
			max = Integer.MIN_VALUE;
			index = Integer.MAX_VALUE;

			for (int i = 1; i < energyList.size() - 1; i++) {
				int left = energyList.get(i - 1);
				int right = energyList.get(i + 1);
				int sum = left * right;

				if (max < sum) {
					max = sum;
					index = i;
				} else if (max == sum) {
					index = energyList.get(index) - energyList.get(i) > 0 ? i : index;
				}
			}

			energySum += max;
			energyList.remove(index);
		}

		System.out.println(energySum);

		scanner.close();
	}

}
