package tests.graph;

import org.junit.Test;
import weapon.graph.BipartiteMatching;

import static junit.framework.TestCase.assertEquals;

public class BipartiteMatchingTest {

  @Test
  public void test() {
    BipartiteMatching matching = new BipartiteMatching(100, 100);

    matching.connect(1, 1);
    matching.connect(2, 2);
    matching.connect(3, 3);
    matching.connect(3, 1);

    matching.solve();

    assertEquals(3, matching.ansCount);
    for (int i = 1; i <= 3; i++) {
      assertEquals(i, matching.ansLeft[i]);
      assertEquals(i, matching.ansRight[i]);
    }
  }

  @Test
  public void test_POJ3041() {
    BipartiteMatching matching = new BipartiteMatching(4, 4);

    matching.connect(1, 1);
    matching.connect(1, 3);
    matching.connect(2, 2);
    matching.connect(3, 2);

    matching.solve();

    assertEquals(2, matching.ansCount);
  }

  @Test
  public void test14() {
    BipartiteMatching matching = new BipartiteMatching(1, 4);

    matching.connect(0, 1);
    matching.connect(0, 2);
    matching.connect(0, 3);
    matching.connect(0, 0);

    matching.solve();

    assertEquals(1, matching.ansCount);
  }

  @Test
  public void test41() {
    BipartiteMatching matching = new BipartiteMatching(4, 1);

    matching.connect(0, 0);
    matching.connect(1, 0);
    matching.connect(2, 0);
    matching.connect(3, 0);

    matching.solve();
  }

}
