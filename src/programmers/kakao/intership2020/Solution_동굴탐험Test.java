package programmers.kakao.intership2020;

import static org.junit.Assert.*;

import org.junit.Test;

public class Solution_동굴탐험Test {

	@Test
	public void testSolution() {
		Solution_동굴탐험_실패 s = new Solution_동굴탐험_실패();
		
		assertEquals(true, s.solution(9, new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}, new int [][] {{8,5},{6,7},{4,1}}));
		assertEquals(true, s.solution(9, new int[][] {{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}}, new int [][] {{4,1},{5,2}}));
		assertEquals(false, s.solution(9, new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}}, new int [][] {{4,1},{8,7},{6,5}}));
	}

}
