package tests.graph.shortestpath;

import weapon.graph.shortestpath.Dijkstra;
import weapon.graph.shortestpath.ShortestPath;

public class DijkstraTest extends ShortestPathTest {

  @Override
  ShortestPath getShortestPath(int size) {
    return new Dijkstra(size);
  }
}
