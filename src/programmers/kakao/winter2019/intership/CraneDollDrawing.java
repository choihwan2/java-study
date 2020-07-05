package programmers.kakao.winter2019.intership;

import java.util.Arrays;
import java.util.Stack;

public class CraneDollDrawing {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] numArr = new int[board.length + 1];
        int n = board.length;
        Stack<Integer> stockStk = new Stack<>();
        Arrays.fill(numArr, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) numArr[j + 1]--;
            }
        }

        // stack이 비었는지?

        for (int i : moves) {
            if (numArr[i] != n) {
                int pick = board[numArr[i]][i - 1];
                if (!stockStk.isEmpty() && stockStk.peek() == pick) {
                    stockStk.pop();
                    answer++;
                } else {
                    stockStk.push(pick);
                }
                numArr[i]++;
            }
        }


        return answer * 2;
    }
}
