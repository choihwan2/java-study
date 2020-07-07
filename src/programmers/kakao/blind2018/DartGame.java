package programmers.kakao.blind2018;

import java.util.Stack;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Integer> answerStk = new Stack<>();

        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);
            if (c >= '0' && c <= '9') {
                answerStk.push(Character.getNumericValue(c));
            } else if (c == '#') {
                answerStk.push(answerStk.pop() * -1);
            } else if (c == '*') {
                Stack<Integer> tempStk = new Stack<>();
                while (!answerStk.isEmpty()) {
                    tempStk.push(answerStk.pop() * 2);
                }
                while (!tempStk.isEmpty()) {
                    answerStk.push(tempStk.pop());
                }
            } else if (c == 'S') {

            } else if (c == 'D') {
                answerStk.push((int) Math.pow(answerStk.pop(), 2));
            } else if (c == 'T') {
                answerStk.push((int) Math.pow(answerStk.pop(), 3));
            }
        }
        for (int i : answerStk) {
            answer += i;
        }
        return answer;
    }
}
