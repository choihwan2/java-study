package programmers.school.day03;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

class NetworkTest {

	@Test
	void testSolution() {
		Network network = new Network();
		Assert.assertEquals(2,network.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
		Assert.assertEquals(1,network.solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
	}

}
