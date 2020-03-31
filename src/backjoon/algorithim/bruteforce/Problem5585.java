package backjoon.algorithim.bruteforce;

import java.io.*;

public class Problem5585{
	
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int MAX = 1000;
        int num = Integer.parseInt(br.readLine());
        int[] coin = {500,100,50,10,5,1};
        int change = MAX - num;
        int answer = 0;
        int ptr = 0;
        
        while(change != 0) {
        	int coin_n = change / coin[ptr];
        	change -= coin_n * coin[ptr++];
        	answer += coin_n;
        }
        System.out.println(answer);
    }
    
    
}