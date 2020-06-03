package programmers.school.day04;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
class TrainingSuitTest {

	@Test
	void test() {
		TrainingSuit s = new TrainingSuit();
		Assert.assertEquals(5, s.solution(5, new int[] {2,4}, new int[] {1,3,5}));
		Assert.assertEquals(4, s.solution(5, new int[] {2,4}, new int[] {3}));
		Assert.assertEquals(2, s.solution(3, new int[] {3}, new int[] {1}));
	}

}
