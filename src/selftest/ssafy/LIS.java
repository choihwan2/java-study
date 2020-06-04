package selftest.ssafy;


import java.util.Arrays;

public class LIS {
    static boolean[] inputBool = new boolean[40];

    public static void main(String[] args) {
        System.out.println(getLISLength(new int[]{3, 6, 1, 2, 7, 6, 3, 5}));
        System.out.println(getLISLength(new int[]{9, 8, 2, 4, 1, 6, 3, 5, 2}));
        System.out.println(getLISLength(new int[]{1, 3, 7, 4, 9, 8, 9, 5, 3, 7}));
        System.out.println(getLISLength(new int[]{1, 8, 3, 2, 4, 8, 3, 2, 7, 6, 4, 1, 3, 5, 7, 6, 9, 5, 4, 7, 2, 8, 9}));
        System.out.println(getLISLength(new int[]{1, 8, 3, 2, 7, 2, 23, 9, 24, 51, 39, 71, 5, 37, 9, 35, 15, 16, 34, 81, 99}));
        System.out.println(getLISLength(new int[]{74, 59, 62, 72, 30, 88, 65, 85, 44, 78, 59, 30, 100, 12, 81, 22, 64, 15, 18, 35, 36, 36, 44, 28, 62, 36, 67, 26, 6, 76}));
    }

    public static int getLISLength(int[] inputs) {
        int[] dp = new int[inputs.length];

        for (int i = 0; i < inputs.length; i++) {
            if (dp[i] == 0) dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (inputs[i] > inputs[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        Arrays.sort(dp);
        return dp[inputs.length - 1];

    }
}
