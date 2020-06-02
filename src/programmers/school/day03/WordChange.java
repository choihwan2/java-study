package programmers.school.day03;

public class WordChange {

	private int answer;
	
	public int solution(String begin, String target, String[] words) {
		boolean[] wordBool = new boolean[words.length];
		answer = 0;
		findTarget(begin, target, 0, wordBool, words);
		return answer;
	}

	private int findTarget(String begin, String target, int index, boolean[] wordBool, String[] words) {
		if (begin.equals(target)) {
			return index;
		}

		for (int i = 0; i < words.length; i++) {
			if (wordBool[i])
				continue;

			if (isChangeable(begin, words[i])) {
				wordBool[i] = true;
				int temp = findTarget(words[i], target, index + 1, wordBool, words);
				wordBool[i] = false;
				if(temp == 0) continue;
				if(answer == 0 || answer > temp)
					answer = temp;
			}

		}
		return 0;
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
