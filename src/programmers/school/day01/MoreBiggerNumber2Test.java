package programmers.school.day01;


import org.junit.Assert;
import org.junit.jupiter.api.Test;


class MoreBiggerNumber2Test {

	@Test
	void test() {
		MoreBiggerNumber2 s = new MoreBiggerNumber2();
		Assert.assertEquals(83, s.solution(78));
		Assert.assertEquals(23, s.solution(15));
	}

}
