package ssafy.swexpert.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution9229_HanvinSpotMart {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int iT = Integer.parseInt(br.readLine());
        for (int t = 1; t <= iT; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            int[] weightArr = new int[N];
            int index = 0;
            StringTokenizer stk = new StringTokenizer(br.readLine());
            while (stk.hasMoreTokens()) {
                weightArr[index++] = Integer.parseInt(stk.nextToken());
            }
            int answer = getAnswer(weightArr,M);
            System.out.println("#" + t + " " + answer);
        }
    }

    private static int getAnswer(int[] arr, int M) {
        int max = -1;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum < M && max < sum) {
                    max = sum;
                }else if(sum == M)
                    return sum;
            }
        }
        return max;
    }
}
