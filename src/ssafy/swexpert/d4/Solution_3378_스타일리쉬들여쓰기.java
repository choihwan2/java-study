package ssafy.swexpert.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기 {
	static int p, q;
	static char[][] master, own;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(stk.nextToken());
			q = Integer.parseInt(stk.nextToken());

			master = new char[p][];
			own = new char[q][];
			result = new int[q];
			Arrays.fill(result, -2);

			for (int i = 0; i < p; i++) {
				master[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < q; i++) {
				own[i] = br.readLine().toCharArray();
			}

			for (int r = 1; r <= 20; r++) {
				for (int c = 1; c <= 20; c++) {
					for (int s = 1; s <= 20; s++) {
						if (isAvailalbe(r, c, s)) { // 마스터 코드에 r,c,s를 적용하여 가능 한지 판단
							processIndent(r, c, s);
						}
					}
				}
			}
			StringBuilder stb = new StringBuilder("#" + t + " ");
			for (int r : result) {
				stb.append(r).append(" ");
			}
			System.out.println(stb.toString());
		}
	}

	private static void processIndent(int r, int c, int s) {
		int rCount = 0, cCount = 0, sCount = 0;
		for (int i = 0; i < q; i++) {
			if (result[i] == -2) {
				result[i] = r * rCount + c * cCount + s * sCount;
			} else {
				if (result[i] != r * rCount + c * cCount + s * sCount) {
					result[i] = -1;
				}
			}

			for (char ch : own[i]) {
				switch (ch) {
				case '(':
					rCount++;
					break;

				case ')':
					rCount--;
					break;

				case '{':
					cCount++;
					break;

				case '}':
					cCount--;
					break;

				case '[':
					sCount++;
					break;

				case ']':
					sCount--;
					break;

				default:
					break;
				}
			}
		}
	}

	private static boolean isAvailalbe(int r, int c, int s) {
		int rCount = 0, cCount = 0, sCount = 0;

		for (int i = 0; i < p; i++) {
			int cnt = 0;
			// 온점 개수 세기 (맨 앞에서 연속된 온점 개수만 세기
			for (char ch : master[i]) {
				if (ch == '.')
					++cnt;
				else
					break;
			}
			int indent = r * rCount + c * cCount + s * sCount;

			if (indent != cnt)
				return false; // 계산된 들여쓰기 개수와 실제 마스터의 들여쓰기 개수가 다르면 r,c,s는 답이 될수 없음

			for (char ch : master[i]) {
				switch (ch) {
				case '(':
					rCount++;
					break;

				case ')':
					rCount--;
					break;

				case '{':
					cCount++;
					break;

				case '}':
					cCount--;
					break;

				case '[':
					sCount++;
					break;

				case ']':
					sCount--;
					break;

				default:
					break;
				}
			}

		}

		return true;
	}
}
