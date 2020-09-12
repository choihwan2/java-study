package programmers.kakao.blind2020;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Solution_01Test {

	@Test
	void test() {
		Solution_01 s = new Solution_01();
		assertEquals("bat.y.abcdefghi", s.solution("...!@BaT#*..y.abcdefghijklm"));
		assertEquals("z--", s.solution("z-+.^."));
		assertEquals("aaa", s.solution("=.="));
		assertEquals("123_.def", s.solution("123_.def"));
		assertEquals("abcdefghijklmn", s.solution("abcdefghijklmn.p"));
	}

}
