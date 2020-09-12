package programmers.kakao.blind2020;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Solution_2Test {

	@Test
	void test() {
		Solution_2 s = new Solution_2();
//		assertEquals(new String[] {"AC", "ACDE", "BCFG", "CDE"}, s.solution(new String[] {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[] {2,3,4}));
//		assertEquals(new String[] {"ACD", "AD", "ADE", "CD", "XYZ"}, s.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5}));
		assertEquals(new String[] {"WX", "XY"}, s.solution(new String[] {"XYZ", "XWY", "WXA"}, new int[] {2,3,4}));
	}

}
