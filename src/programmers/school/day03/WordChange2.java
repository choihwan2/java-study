package programmers.school.day03;

import java.util.*;

public class WordChange2 {

    private class WordNode {
        String word;
        int cnt;

        public WordNode(String word, int cnt) {
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
        Set<String> usedWordSet = new HashSet<>();

        if (!Arrays.asList(words).contains(target))
            return 0;
        Queue<WordNode> que = new LinkedList<>();
        que.add(new WordNode(begin, 0));

        while (!que.isEmpty()) {
            if (que.peek().word.equals(target)) {
                answer = que.peek().cnt;
                break;
            }

            WordNode nowNode = que.poll();
            for (int i = 0; i < words.length; i++) {
                if (usedWordSet.contains(words[i])) continue;
                if (isChangeable(nowNode.word, words[i])) {
                    usedWordSet.add(words[i]);
                    que.add(new WordNode(words[i], nowNode.cnt + 1));
                }
            }
        }

        return answer;
    }

    private boolean isChangeable(String str, String str2) {
        int num = 0;
        for (int i = 0; i < str.length() && num < 2; i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                num++;
            }
        }
        return num == 1;
    }
}
