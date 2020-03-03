package programmers.binarysearch;

public class Budget {

}
class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        int m_max = 0;
        int m_min = 0;
        int sum = 0;

        for(int budget : budgets){
            if(budget > m_max){
                m_max = budget;
            }
        }
        while(m_min <= m_max){
            int middle = (m_min + m_max) / 2;
            sum = 0;

            for(int budget : budgets){
                if(budget < middle){
                    sum += budget;   
                }else{
                    sum += middle;
                }
            }
            if(sum > M){
                m_max = middle -1;
            }else{
                answer = middle;
                m_min = middle +1;
            }
        }
        return answer;
    }
}

