package programmers.kakao.blind2018;

import org.junit.Assert;
import org.junit.Test;


public class Friends4BlockTest {
    @Test
    public void test(){
        Friends4Block f4 = new Friends4Block();
        Assert.assertEquals(14,f4.solution(4,5,new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        Assert.assertEquals(15,f4.solution(6,6,new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));

    }

}