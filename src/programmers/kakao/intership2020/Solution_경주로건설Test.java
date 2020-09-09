package programmers.kakao.intership2020;

import static org.junit.Assert.*;

import org.junit.Test;

public class Solution_경주로건설Test {

	@Test
	public void testSolution() {
		Solution_경주로건설 s = new Solution_경주로건설();
		assertEquals(900, s.solution(new int[][] {{0,0,0},{0,0,0},{0,0,0}}));
		assertEquals(3800, s.solution(new int[][] {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}}));
		assertEquals(2100, s.solution(new int[][] {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}}));
		assertEquals(3200, s.solution(new int[][] {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}));
	}

}
