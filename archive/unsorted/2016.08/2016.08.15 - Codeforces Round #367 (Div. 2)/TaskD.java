package workspace;

import weapon.datastructures.MaxXorTree;
import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskD {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    MaxXorTree mxt = new MaxXorTree(30);
    mxt.insert(0);

    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      String s = in.next();
      int k = in.nextInt();

      if (s.charAt(0) == '?') {
        out.println(mxt.query(k) ^ k);
      } else if (s.charAt(0) == '+') {
        mxt.insert(k);
      } else if (s.charAt(0) == '-') {
        mxt.remove(k);
      }
    }
  }
}
