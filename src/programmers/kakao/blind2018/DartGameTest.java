package programmers.kakao.blind2018;

import org.junit.Test;

import static org.junit.Assert.*;

public class DartGameTest {

    @Test
    public void test(){
        DartGame s = new DartGame();
        assertEquals(37,s.solution("1S2D*3T"));
        assertEquals(9,s.solution("1D2S#10S"));
        assertEquals(3,s.solution("1D2S0T"));
        assertEquals(23,s.solution("1S*2T*3S"));
        assertEquals(5,s.solution("1D#2S*3S"));
        assertEquals(-4,s.solution("1T2D3D#"));
        assertEquals(59,s.solution("1D2S3T*"));
    }

}