package programmers.school.day03;

public class WorkChange {
	private String[] wordsArr;
	private boolean[] wordBool;
	private int answer;

	public int solution(String begin, String target, String[] words) {
		wordBool = new boolean[words.length];
		wordsArr = words;
		answer = 0;
		findTarget(begin, target, 0);
		return answer;
	}

	private int findTarget(String begin, String target, int index) {
		if (begin.equals(target)) {
			return index;
		}

		for (int i = 0; i < wordsArr.length; i++) {
			if (wordBool[i])
				continue;

			if (isChange(begin, wordsArr[i])) {
				wordBool[i] = true;
				int temp = findTarget(wordsArr[i], target, index + 1);
				wordBool[i] = false;
				if(temp == 0) continue;
				if(answer == 0 || answer > temp)
					answer = temp;
			}

		}
		return 0;
	}

	private boolean isChange(String str, String str2) {
		int num = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != str2.charAt(i)) {
				num++;
				if (num == 2) {
					return false;
				}
			}
		}
		return true;
	}
}
