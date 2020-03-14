package softmaestro.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Park {
    static LinkedList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numArr = {"-1", "-1", "1", "7", "4", "5", "9", "8"};

        String input = br.readLine();
        int idx = Integer.parseInt(input);

        list = new LinkedList<>();
        String tmp = "";
        permutation(tmp, numArr, idx);

        int max = list.poll();

        for(int num: list) {
            max = max < num ? num : max;
        }
        System.out.println(max);
    }

    private static void permutation(String str, String[] num, int r) {
        if(r <0){
            return;
        } else if(r==0) {
            // 이때만 추가
            list.add(Integer.parseInt(str));
            return;
        }

        for(int i=2; i <= 7; i++){//**중복 순열과 다른 점
                str+=num[i];
                permutation(str, num, r-i);
                str=str.substring(0,str.length()-1);
            }
    }
}
