package tests.graph;

import org.junit.Test;
import weapon.graph.Dijkstra;

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

    assertEquals(0, dijk.dist[0]);
    assertEquals(1, dijk.dist[1]);
    assertEquals(3, dijk.dist[2]);
    assertEquals(6, dijk.dist[3]);
    assertEquals(10, dijk.dist[4]);
    assertEquals(Dijkstra.INF_DIST, dijk.dist[5]);

    assertEquals(Dijkstra.UNDEFINED, dijk.prev[0]);
    assertEquals(0, dijk.prev[1]);
    assertEquals(0, dijk.prev[2]);
    assertEquals(0, dijk.prev[3]);
    assertEquals(0, dijk.prev[4]);
    assertEquals(Dijkstra.UNDEFINED, dijk.prev[5]);

    dijk.addEdge(1, 3, 4);
    dijk.addEdge(3, 4, 2);

    dijk.solve(0);

    assertEquals(0, dijk.dist[0]);
    assertEquals(1, dijk.dist[1]);
    assertEquals(3, dijk.dist[2]);
    assertEquals(5, dijk.dist[3]);
    assertEquals(7, dijk.dist[4]);
    assertEquals(Dijkstra.INF_DIST, dijk.dist[5]);

    assertEquals(Dijkstra.UNDEFINED, dijk.prev[0]);
    assertEquals(0, dijk.prev[1]);
    assertEquals(0, dijk.prev[2]);
    assertEquals(1, dijk.prev[3]);
    assertEquals(3, dijk.prev[4]);
    assertEquals(Dijkstra.UNDEFINED, dijk.prev[5]);
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

    assertEquals(0, dijk.dist[0]);
    assertEquals(1, dijk.dist[1]);
    assertEquals(3, dijk.dist[2]);
    assertEquals(6, dijk.dist[3]);
    assertEquals(10, dijk.dist[4]);

    assertEquals(Dijkstra.UNDEFINED, dijk.prev[0]);
    assertEquals(0, dijk.prev[1]);
    assertEquals(1, dijk.prev[2]);
    assertEquals(2, dijk.prev[3]);
    assertEquals(3, dijk.prev[4]);
  }
}
