package ssafy.swexpert.d4;

import java.util.Scanner;

public class Solution3289_Coprime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int iT = sc.nextInt();
		for (int t = 1; t <= iT; t++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] setArr = new int[n + 1];
			for (int i = 1; i < setArr.length; i++) {
				setArr[i] = i;
			}
			StringBuilder stb = new StringBuilder();
			stb.append("#").append(t).append(" ");
			for (int k = 0; k < m; k++) {
				int order = sc.nextInt();
				int from = sc.nextInt();
				int to = sc.nextInt();
				if (order == 0) {
					union(from, to, setArr);
				} else if (order == 1) {
					if (find(from, setArr) == find(to, setArr)) {
						stb.append(1);
					} else {
						stb.append(0);
					}
				}
			}
			System.out.println(stb.toString());
		}
	}

	private static int find(int a, int[] arr) {
		if (arr[a] == a)
			return a; // 자신이 루트노드라면 자기노드번호 리턴
		return arr[a] = find(arr[a], arr); // 자신의 부모를 따라 결국 루트노드를 찾아 리턴받고 자신의 부모를 자기 트리의 루트노드로 갱신하여 트리의 depth를 줄인다.
	}

	private static void union(int a, int b, int[] arr) {
		int pa = find(a, arr); // a노드가 속해 있는 트리(그룹)의 루트노드 찾기
		int pb = find(b, arr); // b노드가 속해 있는 트리(그룹)의 루트노드 찾기
		// 두 노드의 루트노드가 다르다면 한쪽 트리에 다른 트리 합치기
		if (pa != pb)
			arr[pb] = pa;
	}
}
