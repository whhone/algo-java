package workspace;

import weapon.io.InputReader;

import java.io.PrintWriter;

public class TaskA {
  public String f(String as) {
    int i = 0;
    while (i < as.length() && as.charAt(i) == '0') {
      ++i;
    }
    return as.substring(i);
  }

  public void solve(int testNumber, InputReader in, PrintWriter out) {

    String as = f(in.next());
    String bs = f(in.next());

    if (as.length() < bs.length()) {
      out.println("<");
    } else if (as.length() > bs.length()) {
      out.println(">");
    } else {
      for (int i = 0; i < as.length(); ++i) {
        if (as.charAt(i) == bs.charAt(i)) {
          continue;
        }

        if (as.charAt(i) < bs.charAt(i)) {
          out.println("<");
        } else {
          out.println(">");
        }
        return;
      }
      out.println("=");
    }

  }
}
