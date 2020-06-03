package programmers.school.day04;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Tile2XTest {

	@Test
	void test() {
		Tile2X s = new Tile2X();
		Assert.assertEquals(5, s.solution(4));
	}

}
