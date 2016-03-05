package tests.graph.flow;

import org.junit.Test;
import weapon.graph.flow.MaxFlow;

import static junit.framework.TestCase.assertEquals;

public class MaxFlowTest {

  @Test
  public void test() {
    MaxFlow maxFlow = new MaxFlow(10);
    assertEquals(0, maxFlow.solve(0, 9));

    maxFlow.addEdge(0, 9, 10);
    assertEquals(10, maxFlow.solve(0, 9));
  }

  @Test
  public void test2() {
    MaxFlow maxFlow = new MaxFlow(10);

    maxFlow.addEdge(0, 3, 10);
    maxFlow.addEdge(3, 5, 10);
    maxFlow.addEdge(5, 9, 10);
    assertEquals(10, maxFlow.solve(0, 9));
  }

  @Test
  public void test3() {
    MaxFlow maxFlow = new MaxFlow(10);
    for (int i = 0; i < 9; i++) {
      maxFlow.addEdge(i, i + 1, 10);
    }
    assertEquals(10, maxFlow.solve(0, 9));
  }

  @Test
  public void test4() {
    MaxFlow maxFlow = new MaxFlow(10);
    maxFlow.addEdge(0, 1, 2);
    maxFlow.addEdge(0, 2, 1);
    maxFlow.addEdge(1, 3, 1);
    maxFlow.addEdge(2, 3, 2);
    assertEquals(2, maxFlow.solve(0, 3));
  }

  @Test
  public void test5() {
    MaxFlow maxFlow = new MaxFlow(10);
    maxFlow.addEdge(0, 1, 2);
    maxFlow.addEdge(0, 2, 1);
    maxFlow.addEdge(1, 3, 1);
    maxFlow.addEdge(2, 3, 2);
    maxFlow.addEdge(1, 2, Integer.MAX_VALUE);
    assertEquals(3, maxFlow.solve(0, 3));
  }
}
