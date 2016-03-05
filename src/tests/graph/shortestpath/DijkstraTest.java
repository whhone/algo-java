package tests.graph.shortestpath;

import junit.framework.Assert;
import org.junit.Test;
import weapon.graph.shortestpath.Dijkstra;
import weapon.graph.shortestpath.ShortestPath;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class DijkstraTest {

  @Test
  public void testBasic() {
    Dijkstra dijk = new Dijkstra(6);
    dijk.addEdge(0, 1, 1);
    dijk.addEdge(0, 2, 3);
    dijk.addEdge(0, 3, 6);
    dijk.addEdge(0, 4, 10);

    dijk.solve(0);

    assertEquals(0, dijk.getCost(0));
    assertEquals(1, dijk.getCost(1));
    assertEquals(3, dijk.getCost(2));
    assertEquals(6, dijk.getCost(3));
    assertEquals(10, dijk.getCost(4));
    assertEquals(Dijkstra.INF_DIST, dijk.getCost(5));

    assertEquals(null, dijk.getFromEdge(0));
    assertEquals(0, dijk.getFromEdge(1).getFrom());
    assertEquals(0, dijk.getFromEdge(2).getFrom());
    assertEquals(0, dijk.getFromEdge(3).getFrom());
    assertEquals(0, dijk.getFromEdge(4).getFrom());
    assertEquals(null, dijk.getFromEdge(5));

    dijk.addEdge(1, 3, 4);
    dijk.addEdge(3, 4, 2);

    dijk.solve(0);

    assertEquals(0, dijk.getCost(0));
    assertEquals(1, dijk.getCost(1));
    assertEquals(3, dijk.getCost(2));
    assertEquals(5, dijk.getCost(3));
    assertEquals(7, dijk.getCost(4));
    assertEquals(Dijkstra.INF_DIST, dijk.getCost(5));

    assertEquals(null, dijk.getFromEdge(0));
    assertEquals(0, dijk.getFromEdge(1).getFrom());
    assertEquals(0, dijk.getFromEdge(2).getFrom());
    assertEquals(1, dijk.getFromEdge(3).getFrom());
    assertEquals(3, dijk.getFromEdge(4).getFrom());
    assertEquals(null, dijk.getFromEdge(5));
  }

  @Test
  public void testCircular() {
    Dijkstra dijk = new Dijkstra(5);
    dijk.addEdge(0, 1, 1);
    dijk.addEdge(1, 2, 2);
    dijk.addEdge(2, 3, 3);
    dijk.addEdge(3, 4, 4);
    dijk.addEdge(4, 2, 5);

    dijk.solve(0);

    assertEquals(0, dijk.getCost(0));
    assertEquals(1, dijk.getCost(1));
    assertEquals(3, dijk.getCost(2));
    assertEquals(6, dijk.getCost(3));
    assertEquals(10, dijk.getCost(4));

    assertEquals(null, dijk.getFromEdge(0));
    assertEquals(0, dijk.getFromEdge(1).getFrom());
    assertEquals(1, dijk.getFromEdge(2).getFrom());
    assertEquals(2, dijk.getFromEdge(3).getFrom());
    assertEquals(3, dijk.getFromEdge(4).getFrom());
  }

  @Test
  public void testGetPath() {
    Dijkstra dijk = new Dijkstra(5);
    dijk.addEdge(0, 1, 1);
    dijk.addEdge(1, 2, 2);
    dijk.addEdge(2, 3, 3);
    dijk.addEdge(3, 4, 4);
    dijk.addEdge(4, 2, 5);

    dijk.solve(0);

    ArrayList<ShortestPath.ShortestPathEdge> path = dijk.getPath(4);
    assertEquals(4, path.size());
    assertEquals(0, path.get(0).getFrom());
    assertEquals(1, path.get(1).getFrom());
    assertEquals(2, path.get(2).getFrom());
    assertEquals(3, path.get(3).getFrom());
  }
}
