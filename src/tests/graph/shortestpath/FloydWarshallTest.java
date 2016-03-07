package tests.graph.shortestpath;

import org.junit.Test;
import weapon.graph.shortestpath.FloydWarshall;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FloydWarshallTest {

  @Test
  public void testNoEdge() {
    FloydWarshall floyd = new FloydWarshall(4);
    assertTrue(floyd.solve());

    assertFalse(floyd.hasNegativeCycle());
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (i != j) {
          assertEquals(FloydWarshall.INF, floyd.getDistance(i, j));
        } else {
          assertEquals(0, floyd.getDistance(i, j));
        }
      }
    }
  }

  @Test
  public void testCompleteGraph() {
    FloydWarshall floyd = new FloydWarshall(4);
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        floyd.addEdge(i, j, 2);
      }
    }
    assertTrue(floyd.solve());

    assertFalse(floyd.hasNegativeCycle());
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (i != j) {
          assertEquals(2, floyd.getDistance(i, j));
        } else {
          assertEquals(0, floyd.getDistance(i, j));
        }
      }
    }
  }

  @Test
  public void testLine() {
    FloydWarshall floyd = new FloydWarshall(10);
    for (int i = 0; i < 10; i++) {
      floyd.addEdge(i, (i + 1) % 10, 1);
    }
    assertTrue(floyd.solve());

    assertFalse(floyd.hasNegativeCycle());
    for (int i = 0; i < 10; i++) {
      for (int j = i; j < 10; j++) {
        assertEquals(j - i, floyd.getDistance(i, j));
      }
    }

    ArrayList<Integer> path = floyd.getPath(0, 9);
    assertEquals(10, path.size());
    for (int i = 0; i < path.size(); i++) {
      assertEquals(i, path.get(i).intValue());
    }
  }

  @Test
  public void testNegativeWeight() {
    FloydWarshall floyd = new FloydWarshall(10);
    for (int i = 0; i < 9; i++) {
      floyd.addEdge(i, i + 1, -1);
    }
    assertTrue(floyd.solve());

    assertFalse(floyd.hasNegativeCycle());
    for (int i = 0; i < 10; i++) {
      for (int j = i; j < 10; j++) {
        assertEquals(i - j, floyd.getDistance(i, j));
      }
    }
  }

  @Test
  public void testNegativeCycle() {
    FloydWarshall floyd = new FloydWarshall(10);
    for (int i = 0; i < 10; i++) {
      floyd.addEdge(i, (i + 1) % 10, -1);
    }
    assertFalse(floyd.solve());
    assertTrue(floyd.hasNegativeCycle());
  }
}
