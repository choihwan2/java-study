package baekjoon.algorithm.stack;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 명령의 수
        int[] arr = new int[n]; // 작업을 위한 배열
        int top = -1; // 배열 위치
        String input; // 명령
        for (int i=0; i<n; i++) {
            input = sc.next();
            
            if (input.equals("push")) // 정수 X를 스택에 넣는 연산이다.
            {
                top++;
                arr[top] = sc.nextInt();
            }
            else if (input.equals("pop")) // 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. (없는 경우에는 -1)
            {
                if (top == -1){
                    System.out.println(-1);
                } else {
                    System.out.println(arr[top]);
                    top--;
                }    
            }
            else if (input.equals("size")) // 스택에 들어있는 정수의 개수를 출력한다.
            {
                System.out.println(top+1);
            }
            else if (input.equals("empty")) // 스택이 비어있으면 1, 아니면 0을 출력한다.
            {
                if (top == -1){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
            else if (input.equals("top"))  // 스택의 가장 위에 있는 정수를 출력한다. (없는 경우에는 -1)
            {
                if (top == -1){
                    System.out.println(-1);
                } else {
                    System.out.println(arr[top]);
                }  
            }   
        }

	}
	
	

}
