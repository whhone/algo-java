package tests.graph;

import org.junit.Test;
import weapon.graph.MinimumSpinningTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MinimumSpinningTreeTest {

  @Test
  public void test() {
    MinimumSpinningTree mst = new MinimumSpinningTree(5);

    for (int i = 0; i < 5; i++) {
      for (int j = i + 1; j < 5; j++) {
        mst.addEdge(i, j, (i + 1) * (j + 1));
      }
    }

    mst.solve();

    assertTrue(mst.getOK());
    assertEquals(14, mst.getMinCost());
    assertEquals(2, mst.getTreeEdges().get(0).cost);
    assertEquals(3, mst.getTreeEdges().get(1).cost);
    assertEquals(4, mst.getTreeEdges().get(2).cost);
    assertEquals(5, mst.getTreeEdges().get(3).cost);
  }

  @Test
  public void testNotOk() {
    MinimumSpinningTree mst = new MinimumSpinningTree(4);
    mst.addEdge(0, 1, 1);
    mst.addEdge(2, 3, 1);

    mst.solve();

    assertFalse(mst.getOK());
  }
}
