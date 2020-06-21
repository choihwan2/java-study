package programmers.dfsbfs;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


class TravelRouteTest {
    @Test
    public void test() {
        TravelRoute s = new TravelRoute();
        Assert.assertArrayEquals(new String[] {"ICN", "JFK", "HND", "IAD"},s.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));
        Assert.assertArrayEquals(new String[] {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"},s.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}}));
    }
}