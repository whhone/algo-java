package tests.graph.shortestpath;

import weapon.graph.shortestpath.SPFA;
import weapon.graph.shortestpath.ShortestPath;

public class SPFATest extends ShortestPathTest {

  @Override
  ShortestPath getShortestPath(int size) {
    return new SPFA(size);
  }
}
