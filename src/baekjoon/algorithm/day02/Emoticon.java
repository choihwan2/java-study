package baekjoon.algorithm.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Emoticon {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] list = new int[N + 1][N +1];
        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(list[i], -1);
        }
        Queue<Integer> que = new LinkedList<>();
        list[1][0] = 0;

        que.add(1);
        que.add(0);

        while (!que.isEmpty()) {
            int now = que.poll();
            int copy = que.poll();

            if (now + copy < N + 1 && list[now + copy][copy] == -1) {
                list[now + copy][copy] = list[now][copy] + 1;
                que.add(now + copy);
                que.add(copy);
            }

            if (list[now][now] == -1) {
                list[now][now] = list[now][copy] + 1;
                que.add(now);
                que.add(now);
            }

            if (now -1 >= 0 && list[now - 1][copy] == -1) {
                list[now - 1][copy] = list[now][copy] + 1;
                que.add(now - 1);
                que.add(copy);
            }
        }
        int answer = -1;
        for (int i = 0; i < N + 1; i++) {
            if(answer == -1 || answer > list[N][i])
                answer = list[N][i];
        }
        System.out.println(answer);
    }
}
