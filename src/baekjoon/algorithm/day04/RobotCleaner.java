package baekjoon.algorithm.day04;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RobotCleaner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        List<Integer> answerList = new ArrayList<>();

        while (true) {
            String wh = s.nextLine();
            if (wh.charAt(0) == '0' && wh.charAt(2) == '0') break;
            int w = Character.getNumericValue(wh.charAt(0));
            int h = Character.getNumericValue(wh.charAt(2));
            char[][] map = new char[h][w];
            for(int i = 0; i< h; i++){
                map[i] = s.nextLine().toCharArray();
            }

        }

        for (int i : answerList) {
            System.out.println(i);
        }

    }
}
