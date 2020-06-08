package programmers.school.day03;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WordChange2 {

    private class Word {
        String word;
        int cnt;

        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        public String getWord() {
            return word;
        }

        public int getCnt() {
            return cnt;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] wordBool = new boolean[words.length];

        if (!Arrays.asList(words).contains(target))
            return 0;
        Queue<Word> que = new LinkedList<>();
        que.add(new Word(begin, 0));

        while (!que.isEmpty()) {
            if (que.peek().word.equals(target)) {
                answer = que.poll().cnt;
                break;
            }

            Word nowWord = que.poll();

            for (int i = 0; i < words.length; i++) {
                if (wordBool[i]) continue;
                if (isChangeable(nowWord.word, words[i])) {
                    wordBool[i] = true;
                    que.add(new Word(words[i], nowWord.cnt + 1));
                }
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
