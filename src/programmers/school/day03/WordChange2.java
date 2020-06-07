package programmers.school.day03;

import java.util.Stack;

public class WordChange2 {


    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] wordBool = new boolean[words.length];
        String start = begin;

        for (int i = 0; i < words.length; i++) {
            Stack<String> stack = new Stack<>();
            if(isChangeable(begin,words[i])){
                stack.push(words[i]);
                start = words[i];
                wordBool[i] = true;
            }
            while(!stack.isEmpty() && !stack.peek().equals(target)){

            }
        }
        return answer;
    }

    private boolean isChangeable(String str, String str2) {
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                num++;
                if (num == 2) {
                    return false;
                }
            }
        }
        return num == 0 ? false : true;
    }
}
