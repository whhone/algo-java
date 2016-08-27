package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class TaskD {

  class Node {
    int i, total;
    List<Edge> next = new ArrayList<Edge>();
    Node(int i) {
      this.i = i;
    }
  }

  class Edge {
    int v, ops, x, y;
    Edge(int v) {
      this.v = v;
    }
  }

  Node[] nodes = new Node[100005];

  int n, m, q, total;
  int[] flip = new int[1005];
  int[][] cell = new int[1005][1005];
  int[] sum = new int[1005];

  int getCell(int x, int y) {
    return flip[x] ^ cell[x][y];
  }

  void toggleCell(int x, int y) {
    cell[x][y] ^= 1;
  }

  void maybeAdd(int x, int y) {
    if (getCell(x, y) == 0) {
      toggleCell(x, y);
      ++total;
      sum[x]++;
    }
  }

  void maybeRemove(int x, int y) {
    if (getCell(x, y) == 1) {
      toggleCell(x, y);
      --total;
      sum[x]--;
    }
  }

  void flip(int x) {
    flip[x] ^= 1;
    total -= sum[x];
    sum[x] = m - sum[x];
    total += sum[x];
  }

  void dfs(int u) {
    // System.out.printf("dfs %d %d\n", u, total);
    nodes[u].total = total;

    for (Edge e: nodes[u].next) {
      if (e.ops == 1) {
        int yes = getCell(e.x, e.y);
        maybeAdd(e.x, e.y);
        dfs(e.v);
        if (yes == 0) {
          maybeRemove(e.x, e.y);
        }
      } else if (e.ops == 2) {
        int yes = getCell(e.x, e.y);
        maybeRemove(e.x, e.y);
        dfs(e.v);
        if (yes == 1) {
          maybeAdd(e.x, e.y);
        }
      } else if (e.ops == 3) {
        flip(e.x);
        dfs(e.v);
        flip(e.x);
      } else if (e.ops == 4) {
        dfs(e.v);
      }
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    m = in.nextInt();
    q = in.nextInt();

    for (int i = 0; i <= q; i++) {
      nodes[i] = new Node(i);
    }
    for (int i = 1; i <= q; i++) {
      Edge e = new Edge(i);
      e.ops = in.nextInt();
      e.x = in.nextInt();
      if (e.ops <= 2) {
        e.y = in.nextInt();
      }
      if (e.ops == 4) {
        nodes[e.x].next.add(e);
      } else {
        nodes[i-1].next.add(e);
      }
    }
    dfs(0);
    for (int i = 1; i <= q; i++) {
      out.println(nodes[i].total);
    }
  }
}
