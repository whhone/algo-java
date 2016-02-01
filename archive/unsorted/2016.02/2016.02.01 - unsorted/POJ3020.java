package workspace;

import utils.InputReader;
import utils.OutputWriter;
import weapon.graph.BipartiteMatching;

public class POJ3020 {

  int[] dx = {-1, +1, 0, 0};
  int[] dy = {0, 0, -1, +1};

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();
    for (int tt = 0; tt < T; tt++) {
      int H = in.nextInt();
      int W = in.nextInt();

      int count = 0;
      String[] c = new String[H];
      for (int i = 0; i < H; i++) {
        c[i] = in.nextLine();
        for (int j = 0; j < W; j++) {
          if (c[i].charAt(j) == '*') {
            ++count;
          }
        }
      }
      BipartiteMatching matching = new BipartiteMatching(450, 450);
      for (int i = 0; i < H; i++) {
        for (int j = 1 - i % 2; j < W; j+=2) {
          for (int k = 0; k < 4; k++) {
            int yy = i + dy[k];
            int xx = j + dx[k];
            if (yy >= 0 && yy < H && xx >= 0 && xx < W) {
              if (c[i].charAt(j) == '*' && c[yy].charAt(xx) == '*') {
                matching.connect(i * 10 + j, yy * 10 + xx);
              }
            }
          }
        }
      }
      matching.solve();
      out.printf("%d\n", count - matching.ansCount);
    }
  }
}
