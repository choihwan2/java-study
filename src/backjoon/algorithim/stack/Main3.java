package backjoon.algorithim.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main3{
    public static void main(String args[]){
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        
        for(int i =0; i<num; i++){
            int input = scanner.nextInt();
            scanner.nextLine();
            if(input == 0){
                stack.pop();
            } else{
                stack.push(input);
            }
        }
        
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        System.out.println(sum);
        
        
    }
}
