package programmers.school.day03;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

class WorkChangeTest {

	@Test
	void test() {
		WorkChange workChange = new WorkChange();
		Assert.assertEquals(4, workChange.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
		Assert.assertEquals(0, workChange.solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));
	}

}
