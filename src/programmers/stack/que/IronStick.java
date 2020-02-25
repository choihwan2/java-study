package programmers.stack.que;

import java.util.Stack;

public class IronStick {

	
	
}

class Solution {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Character> stack = new Stack<Character>();
        String str = arrangement.replace("()","0");
        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
                answer++;
            }
            if(str.charAt(i) == '0'){
                answer+=stack.size();
            }
            if(str.charAt(i) == ')'){
                stack.pop();
            }
        }
        return answer;
    }
}
