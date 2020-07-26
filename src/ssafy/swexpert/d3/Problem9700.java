package ssafy.swexpert.d3;

import java.util.Scanner;

public class Problem9700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int iT = sc.nextInt();
        for (int i = 1; i <= iT; i++) {
            double p = sc.nextDouble();
            double q = sc.nextDouble();
            double s1 = 1 * (1 - p) * q;
            double s2 = 1 * (1 - q) * p * q;

            if (s1 < s2) {
                System.out.println("#" + i + " " + "YES");
            } else
                System.out.println("#" + i + " " + "NO");
        }
    }
}
