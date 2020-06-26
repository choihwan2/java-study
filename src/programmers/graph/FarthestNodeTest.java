package programmers.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class FarthestNodeTest {
    @Test
    public void test(){
        FarthestNode s = new FarthestNode();
        assertEquals(3,s.solution(6,new int[][] {{3, 6},{4, 3},{3, 2},{1, 3},{1, 2},{2, 4},{5, 2}}));
    }

}