package programmers.school.day04;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Tile3XTest {

	@Test
	void test() {
		Tile3X s = new Tile3X();
		Assert.assertEquals(11, s.solution(4));
	}

}
