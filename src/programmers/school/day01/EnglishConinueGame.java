package programmers.school.day01;

import java.util.Arrays;
import java.util.HashSet;

public class EnglishConinueGame {

	public static void main(String[] args) {
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
//		String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
//		String[] words = { "hello", "ejej", "even", "never", "now", "world", "draw" };
		System.out.println(Arrays.toString(solution(3, words)));
	}

	public static int[] solution(int n, String[] words) {
		int[] answer = { 0, 0 };
		HashSet<String> word_set = new HashSet<>();
		int cnt = n;
		String word = words[0];
		word_set.add(word);
		for (int i = 1; i < words.length; i++) {
			cnt++;
			if (word.charAt(word.length() - 1) != words[i].charAt(0)) {
				answer[0] = cnt % n + 1;
				answer[1] = cnt / n;
				break;
			}
			word = words[i];

			if (!word_set.contains(word)) {
				word_set.add(word);
			} else {
				answer[0] = (cnt % n) + 1;
				answer[1] = cnt / n;
				break;
			}
		}

		return answer;
	}

}
