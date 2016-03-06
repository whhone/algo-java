package tests.graph.shortestpath;

import org.junit.Test;
import weapon.graph.shortestpath.Dijkstra;
import weapon.graph.shortestpath.ShortestPath;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public abstract class ShortestPathTest {

  abstract ShortestPath getShortestPath(int size);

  @Test
  public void testBasic() {
    ShortestPath shortestPath = this.getShortestPath(6);
    shortestPath.addEdge(0, 1, 1);
    shortestPath.addEdge(0, 2, 3);
    shortestPath.addEdge(0, 3, 6);
    shortestPath.addEdge(0, 4, 10);

    shortestPath.solve(0);

    assertEquals(0, shortestPath.getCost(0));
    assertEquals(1, shortestPath.getCost(1));
    assertEquals(3, shortestPath.getCost(2));
    assertEquals(6, shortestPath.getCost(3));
    assertEquals(10, shortestPath.getCost(4));
    assertEquals(Dijkstra.INF_DIST, shortestPath.getCost(5));

    assertEquals(null, shortestPath.getFromEdge(0));
    assertEquals(0, shortestPath.getFromEdge(1).getFrom());
    assertEquals(0, shortestPath.getFromEdge(2).getFrom());
    assertEquals(0, shortestPath.getFromEdge(3).getFrom());
    assertEquals(0, shortestPath.getFromEdge(4).getFrom());
    assertEquals(null, shortestPath.getFromEdge(5));

    shortestPath.addEdge(1, 3, 4);
    shortestPath.addEdge(3, 4, 2);

    shortestPath.solve(0);

    assertEquals(0, shortestPath.getCost(0));
    assertEquals(1, shortestPath.getCost(1));
    assertEquals(3, shortestPath.getCost(2));
    assertEquals(5, shortestPath.getCost(3));
    assertEquals(7, shortestPath.getCost(4));
    assertEquals(Dijkstra.INF_DIST, shortestPath.getCost(5));

    assertEquals(null, shortestPath.getFromEdge(0));
    assertEquals(0, shortestPath.getFromEdge(1).getFrom());
    assertEquals(0, shortestPath.getFromEdge(2).getFrom());
    assertEquals(1, shortestPath.getFromEdge(3).getFrom());
    assertEquals(3, shortestPath.getFromEdge(4).getFrom());
    assertEquals(null, shortestPath.getFromEdge(5));
  }


  @Test
  public void testCircular() {
    ShortestPath shortestPath = this.getShortestPath(5);
    shortestPath.addEdge(0, 1, 1);
    shortestPath.addEdge(1, 2, 2);
    shortestPath.addEdge(2, 3, 3);
    shortestPath.addEdge(3, 4, 4);
    shortestPath.addEdge(4, 2, 5);

    shortestPath.solve(0);

    assertEquals(0, shortestPath.getCost(0));
    assertEquals(1, shortestPath.getCost(1));
    assertEquals(3, shortestPath.getCost(2));
    assertEquals(6, shortestPath.getCost(3));
    assertEquals(10, shortestPath.getCost(4));

    assertEquals(null, shortestPath.getFromEdge(0));
    assertEquals(0, shortestPath.getFromEdge(1).getFrom());
    assertEquals(1, shortestPath.getFromEdge(2).getFrom());
    assertEquals(2, shortestPath.getFromEdge(3).getFrom());
    assertEquals(3, shortestPath.getFromEdge(4).getFrom());
  }

  @Test
  public void testGetPath() {
    ShortestPath shortestPath = this.getShortestPath(5);
    shortestPath.addEdge(0, 1, 1);
    shortestPath.addEdge(1, 2, 2);
    shortestPath.addEdge(2, 3, 3);
    shortestPath.addEdge(3, 4, 4);
    shortestPath.addEdge(4, 2, 5);

    shortestPath.solve(0);

    ArrayList<ShortestPath.ShortestPathEdge> path = shortestPath.getPath(4);
    assertEquals(4, path.size());
    assertEquals(0, path.get(0).getFrom());
    assertEquals(1, path.get(1).getFrom());
    assertEquals(2, path.get(2).getFrom());
    assertEquals(3, path.get(3).getFrom());
  }
}
