package baekjoon.algorithm.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Tower {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] answer = new int[n];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        Stack<Integer> baseTower = new Stack<>();
        Stack<Integer> waitStack = new Stack<>();
        int index = 0;
        while (stk.hasMoreTokens()) {
            baseTower.push(index++);
            baseTower.push(Integer.parseInt(stk.nextToken()));
        }

        while (!baseTower.isEmpty()) {
            int height = baseTower.pop();
            int pos = baseTower.pop();
            while (!waitStack.isEmpty() && waitStack.peek() < height) {
                waitStack.pop();
                answer[waitStack.pop()] = pos + 1;
            }
            waitStack.push(pos);
            waitStack.push(height);
        }

        while (!waitStack.isEmpty()) {
            waitStack.pop();
            answer[waitStack.pop()] = 0;
        }
        for(int i = 0; i< answer.length; i++) {
            bw.append(answer[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
