package workspace;

import javafx.util.Pair;
import weapon.io.InputReader;

import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class CF620C {
  public void solve(int testNumber, InputReader in, PrintWriter out) {
    int N = in.nextInt();
    HashSet<Integer> set = new HashSet<Integer>();
    List<Integer> l = new ArrayList<Integer>();
    List<Integer> r = new ArrayList<Integer>();
    int p = -1;
    for (int i = 0; i < N; ++i) {
      int a = in.nextInt();
      if (set.contains(a)) {
        l.add(p + 1);
        r.add(i);
        p = i;
        set.clear();
      } else {
        set.add(a);
      }
    }
    int ans = l.size();
    if (ans == 0) {
      out.println("-1");
    } else {
      if (!set.isEmpty()) {
        r.set(ans - 1, N - 1);
      }
      out.println(ans);
      for (int i = 0; i < ans; ++i) {
        out.printf("%d %d\n", l.get(i) + 1, r.get(i) + 1);
      }
    }
  }
}
