package tests.graph.shortestpath;

import org.junit.Test;
import weapon.graph.shortestpath.Dijkstra;
import weapon.graph.shortestpath.SPFA;

import static junit.framework.TestCase.assertEquals;

public class SPFATest {
  @Test
  public void testBasic() {
    SPFA spfa = new SPFA(6);
    spfa.addEdge(0, 1, 1);
    spfa.addEdge(0, 2, 3);
    spfa.addEdge(0, 3, 6);
    spfa.addEdge(0, 4, 10);

    spfa.solve(0);

    assertEquals(0, spfa.getCost(0));
    assertEquals(1, spfa.getCost(1));
    assertEquals(3, spfa.getCost(2));
    assertEquals(6, spfa.getCost(3));
    assertEquals(10, spfa.getCost(4));
    assertEquals(Dijkstra.INF_DIST, spfa.getCost(5));

    assertEquals(null, spfa.getFromEdge(0));
    assertEquals(0, spfa.getFromEdge(1).getFrom());
    assertEquals(0, spfa.getFromEdge(2).getFrom());
    assertEquals(0, spfa.getFromEdge(3).getFrom());
    assertEquals(0, spfa.getFromEdge(4).getFrom());
    assertEquals(null, spfa.getFromEdge(5));

    spfa.addEdge(1, 3, 4);
    spfa.addEdge(3, 4, 2);

    spfa.solve(0);

    assertEquals(0, spfa.getCost(0));
    assertEquals(1, spfa.getCost(1));
    assertEquals(3, spfa.getCost(2));
    assertEquals(5, spfa.getCost(3));
    assertEquals(7, spfa.getCost(4));
    assertEquals(Dijkstra.INF_DIST, spfa.getCost(5));

    assertEquals(null, spfa.getFromEdge(0));
    assertEquals(0, spfa.getFromEdge(1).getFrom());
    assertEquals(0, spfa.getFromEdge(2).getFrom());
    assertEquals(1, spfa.getFromEdge(3).getFrom());
    assertEquals(3, spfa.getFromEdge(4).getFrom());
    assertEquals(null, spfa.getFromEdge(5));
  }
}
