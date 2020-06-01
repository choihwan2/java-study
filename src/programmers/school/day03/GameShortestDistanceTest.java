package programmers.school.day03;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GameShortestDistanceTest {

	@Test
	void test() {
		GameShortestDistance s = new GameShortestDistance();
		Assert.assertEquals(11, s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
		Assert.assertEquals(-1, s.solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
	}

}
