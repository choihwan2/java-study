package ssafy.swexpert.d4;

import java.util.Scanner;
 
public class Solution_3234_양팔저울2{
 
    static int t, n, result[], num[], count;
    static boolean visit[];
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner kb = new Scanner(System.in);
        t = kb.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            count=0;
            n = kb.nextInt();
            num = new int[n];
            result = new int[n];
            visit = new boolean[n];
            for (int i = 0; i < n; i++) {
                num[i] = kb.nextInt();
            }
            permu(0);
            System.out.println("#"+tc+" "+count);
        }
 
    }
 
    private static void permu(int k) {
        // TODO Auto-generated method stub
        if (k == n) {
            powerSet(0,0,0);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[k] = num[i];
                permu(k + 1);
                visit[i] =false;
            }
        }
 
    }
 
    private static void powerSet(int k,int r,int l) {
        // TODO Auto-generated method stub
        if(r>l) {
            return;
        }
        if(k==n) {
            count++;
            return;
        }
        powerSet(k+1,r+result[k],l);
        powerSet(k+1,r,l+result[k]);
    }
 
}