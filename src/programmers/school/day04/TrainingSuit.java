package programmers.school.day04;

import java.util.HashSet;
import java.util.Set;

public class TrainingSuit {
	public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Set<Integer> lostSet = new HashSet<>();
        for (Integer i : lost) {
			lostSet.add(i);
		}
        for (Integer r : reserve) {
			if(lostSet.contains(r -1)) {
				lostSet.remove(r -1);
			}else if(lostSet.contains(r +1)) {
				lostSet.remove(r +1);
			}
		}
        answer = n - lostSet.size();
        return answer;
    }
}
