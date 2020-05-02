package baekjoon.algorithm.string;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1157 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        String str = scanner.nextLine().toLowerCase();
        for(int i =0; i< str.length(); i++){
            arr[(int)(str.charAt(i) - 'a')]++;
        }
        int max = 0;
        char c = '?';
        for(int  i =0; i< arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                c = (char)('A' + i);
                continue;
            }else if(max == arr[i]){
                c = '?';
            }
        }
        System.out.println(c);
	}
}
