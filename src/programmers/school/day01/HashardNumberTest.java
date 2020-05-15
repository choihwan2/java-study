package programmers.school.day01;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class HashardNumberTest {

	@Test
	void testSolution() {
		HashardNumber s = new HashardNumber();
		
		Assert.assertEquals(true,s.solution(10));
		Assert.assertEquals(true,s.solution(12));
		Assert.assertEquals(false,s.solution(11));
		Assert.assertEquals(false,s.solution(14));
	}

}
