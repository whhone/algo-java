package tests.graph;

import org.junit.Test;
import weapon.graph.StronglyConnectedComponent;

import static junit.framework.TestCase.assertEquals;

public class StronglyConnectedComponentTest {

  @Test
  public void test1() {
    StronglyConnectedComponent scc = new StronglyConnectedComponent(5);
    scc.addEdge(0, 1);
    scc.addEdge(1, 2);
    scc.addEdge(2, 0);
    scc.addEdge(4, 3);
    scc.solve();

    assertEquals(3, scc.getComponentCount());
    assertEquals(2, scc.getNodeComponent(0));
    assertEquals(2, scc.getNodeComponent(1));
    assertEquals(2, scc.getNodeComponent(2));
    assertEquals(1, scc.getNodeComponent(3));
    assertEquals(0, scc.getNodeComponent(4));
  }

  @Test
  public void test2() {
    StronglyConnectedComponent scc = new StronglyConnectedComponent(5);
    scc.addEdge(0, 1);
    scc.addEdge(1, 2);
    scc.addEdge(2, 3);
    scc.addEdge(3, 4);

    scc.solve();

    assertEquals(5, scc.getComponentCount());
    assertEquals(0, scc.getNodeComponent(0));
    assertEquals(1, scc.getNodeComponent(1));
    assertEquals(2, scc.getNodeComponent(2));
    assertEquals(3, scc.getNodeComponent(3));
    assertEquals(4, scc.getNodeComponent(4));
  }

  @Test
  public void test3() {
    StronglyConnectedComponent scc = new StronglyConnectedComponent(5);
    scc.addEdge(0, 1);
    scc.addEdge(1, 2);
    scc.addEdge(2, 3);
    scc.addEdge(3, 4);
    scc.addEdge(3, 1);

    scc.solve();

    assertEquals(3, scc.getComponentCount());
    assertEquals(0, scc.getNodeComponent(0));
    assertEquals(1, scc.getNodeComponent(1));
    assertEquals(1, scc.getNodeComponent(2));
    assertEquals(1, scc.getNodeComponent(3));
    assertEquals(2, scc.getNodeComponent(4));
  }

  @Test
  public void testCompletedGraph() {
    StronglyConnectedComponent scc = new StronglyConnectedComponent(5);
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i != j) {
          scc.addEdge(i, j);
        }
      }
    }

    scc.solve();

    assertEquals(1, scc.getComponentCount());
    assertEquals(0, scc.getNodeComponent(0));
    assertEquals(0, scc.getNodeComponent(1));
    assertEquals(0, scc.getNodeComponent(2));
    assertEquals(0, scc.getNodeComponent(3));
    assertEquals(0, scc.getNodeComponent(4));
  }
}
