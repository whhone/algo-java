package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

import java.math.BigInteger;

public class AA {
  private int ansd, ansa, ansb;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String a = in.next();
    String b = in.next();
    int l = a.length();
    ansd = 99999;

    for (int aa = 0; aa <= 999; aa++) {
      for (int bb = 0; bb <= 999; bb++) {
        if (match(aa, a) && match(bb, b)) {
          int d = Math.abs(aa - bb);
          if (d < ansd) {
            ansd = d;
            ansa = aa;
            ansb = bb;
          } else if (d == ansd) {
            if (aa < ansa) {
              ansa = aa;
              ansb = bb;
            } else if (aa == ansa) {
              if (bb < ansb) {
                ansa = aa;
                ansb = bb;
              }
            }
          }
        }
      }
    }


    out.printf("Case #%d: %s %s\n", testNumber, zero(ansa, a.length()), zero(ansb, a.length()));
  }

  private String zero(int a, int l) {
    String b = String.valueOf(a);
    while (b.length() < l) {
      b = '0' + b;
    }
    return b;
  }

  private boolean match(int aa, String a) {
    String b = zero(aa, a.length());
    if (b.length() != a.length()) {
      return false;
    }

    for (int i = 0; i < b.length(); i++) {
      if (a.charAt(i) == '?') {
        continue;
      } else if (a.charAt(i) != b.charAt(i)){
        return false;
      }
    }
    return true;
  }

}
