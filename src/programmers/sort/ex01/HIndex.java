package programmers.sort.ex01;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        for (int i = 0; i <= 1000; i++) {
            int up = 0;
            int down = 0;
            for (int temp : citations) {
                if (temp >= i) up++;
                if (temp <= i) down++;
            }

            if (up >= i && down <= i) answer = i;
        }
        return answer;
    }
}
