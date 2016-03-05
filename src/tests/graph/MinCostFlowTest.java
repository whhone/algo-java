package tests.graph;

import org.junit.Test;
import weapon.graph.MinCostFlow;

import static junit.framework.TestCase.assertEquals;

public class MinCostFlowTest {

  @Test
  public void test1() {
    MinCostFlow mcf = MinCostFlow.byDijkstra(10);
    mcf.addEdge(0, 1, 100, 100);
    mcf.solve(0, 1);
    assertEquals(100, mcf.getMaxFlow());
    assertEquals(10000, mcf.getMinCost());
  }

  @Test
  public void test2() {
    MinCostFlow mcf = MinCostFlow.byDijkstra(10);
    mcf.addEdge(0, 1, 150, 100);
    mcf.addEdge(0, 2, 50, 100);
    mcf.addEdge(1, 3, 150, 100);
    mcf.addEdge(2, 3, 50, 100);

    mcf.addEdge(3, 4, 50, 100);
    mcf.addEdge(3, 5, 150, 100);
    mcf.addEdge(4, 6, 50, 100);
    mcf.addEdge(5, 6, 150, 100);

    mcf.solve(0, 6);
    assertEquals(200, mcf.getMaxFlow());
    assertEquals(80000, mcf.getMinCost());
  }
}
