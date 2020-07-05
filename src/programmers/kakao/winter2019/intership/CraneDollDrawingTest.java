package programmers.kakao.winter2019.intership;

import org.junit.Test;

import static org.junit.Assert.*;

public class CraneDollDrawingTest {
    @Test
    public void test() {
        CraneDollDrawing s = new CraneDollDrawing();
        assertEquals(4, s.solution(new int[][]{{
                0, 0, 0, 0, 0
        }, {
                0, 0, 1, 0, 3
        }, {
                0, 2, 5, 0, 1
        }, {
                4, 2, 4, 4, 2
        }, {
                3, 5, 1, 3, 1
        }}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }
}