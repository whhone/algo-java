package workspace;

import weapon.datastructures.BinaryIndexedTree2D;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class POJ1195 {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int cmd;
    BinaryIndexedTree2D bit = new BinaryIndexedTree2D(1, 1);
    do {
      cmd = in.nextInt();
      switch (cmd) {
        case 0:
          int n = in.nextInt();
          bit = new BinaryIndexedTree2D(n, n);
          break;
        case 1:
          bit.addValue(in.nextInt() + 1, in.nextInt() + 1, in.nextInt());
          break;
        case 2:
          out.println(bit.querySum(in.nextInt() + 1, in.nextInt() + 1, in.nextInt() + 1, in.nextInt() + 1));
          break;
      }
    } while (cmd != 3);
  }
}
