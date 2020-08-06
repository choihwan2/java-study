package baekjoon.algorithm.recursive;

import java.util.Scanner;

public class Test02{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(x);
    }
    
    public static int fiv(int num){
        if(num == 0){
            return 0;
        }else if(num == 1){
            return 1;
        }else {
            return fiv(num - 1) + fiv(num - 2);
        }
    }
}
