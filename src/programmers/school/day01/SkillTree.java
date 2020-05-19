package programmers.school.day01;

public class SkillTree {
	private String baseSkill;
	private int len;

	public int solution(String skill, String[] skill_trees) {
		baseSkill = skill;
		len = baseSkill.length();
		int answer = 0;
		for (int i = 0; i < skill_trees.length; i++) {
			int pos = 0;
			boolean inSkill = true;
			for (int j = 0; j < skill_trees[i].length(); j++) {
				char c = skill_trees[i].charAt(j);
				if (checkSkill(c)) {
					if (pos < skill.length() && skill.charAt(pos) == c) {
						pos++;
					} else if (pos == skill.length()) {
						break;
					} else {
						inSkill = false;
						break;
					}
				}
			}
			if (inSkill) {
				answer++;
			}
		}
		return answer;
	}

	private boolean checkSkill(char c) {
		for (int i = 0; i < len; i++) {
			if (baseSkill.charAt(i) == c)
				return true;
		}
		return false;
	}

}
