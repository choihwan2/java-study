package programmers.bruteforce;

import java.util.HashMap;
import java.util.Map;

public class TrainingClothes {

	public static void main(String[] args) {
		int n = 3;
		int[] lost = {3};
		int[] reserve = {1};
		System.out.println(solution(n, lost, reserve));

	}

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Map<Integer, Integer> people = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
			people.put(i, 1);
		}

        for (int i = 0; i < reserve.length; i++) {
        	people.replace(reserve[i], 2);
        }
        
        for (int i = 0; i < lost.length; i++) {
        	if(people.get(lost[i]) == 1) {
        		people.replace(lost[i], 0);        		
        	}else {
				people.replace(lost[i], 1);
			}
        }
        
        for(int i = 0; i<reserve.length; i++) {
        	if(people.get(reserve[i]) == 2) {
        		if(people.get(reserve[i] -1) !=null && people.get(reserve[i] -1) == 0) {
        			people.replace(reserve[i]-1, 1);
        			continue;
        		}else if(people.get(reserve[i] +1) !=null && people.get(reserve[i] +1) == 0) {
					people.replace(reserve[i]+1, 1);
				}
        	}
        }
        
        for (int i : people.keySet()) {
			if(people.get(i) >= 1) {
				answer++;
			}
		}
        
        
        return answer;
    }
}
