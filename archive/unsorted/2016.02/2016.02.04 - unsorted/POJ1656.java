package workspace;

import io.InputReader;
import io.OutputWriter;
import weapon.datastructures.BinaryIndexedTree2D;

public class POJ1656 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[][] a = new int[100][100];
    for (int tt = 0; tt < n; tt++) {
      String command = in.next();
      int x = in.nextInt() - 1, y = in.nextInt() - 1, L = in.nextInt();
      if (command.equals("BLACK")) {
        for (int i = x; i < x + L; i++) {
          for (int j = y; j < y + L; j++) {
            a[i][j] = 1;
          }
        }
      } else if (command.equals("WHITE")) {
        for (int i = x; i < x + L; i++) {
          for (int j = y; j < y + L; j++) {
            a[i][j] = 0;
          }
        }
      } else {
        int sum = 0;
        for (int i = x; i < x + L; i++) {
          for (int j = y; j < y + L; j++) {
            sum += a[i][j];
          }
        }
        out.println(sum);
      }
    }
  }
}
