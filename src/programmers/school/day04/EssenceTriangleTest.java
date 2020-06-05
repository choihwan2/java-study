package programmers.school.day04;


import org.junit.Assert;
import org.junit.jupiter.api.Test;

class EssenceTriangleTest {

    @Test
    void test() {
        EssenceTriangle s = new EssenceTriangle();
        Assert.assertEquals(30, s.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
}