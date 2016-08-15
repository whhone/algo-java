package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

import java.math.BigInteger;

public class A {

  BigInteger mind;
  BigInteger ansa, ansb;

  void doit(int i, int c, String a, String b) {

    // System.out.printf("%d %d %s %s : %s\n", i, c, a, b, mind.toString());
    if (i >= a.length()) {
      BigInteger ba = new BigInteger(a);
      BigInteger bb = new BigInteger(b);
      BigInteger d = bb.subtract(ba).abs();
      if (mind.compareTo(d) > 0) {
        mind = d;
        ansa = ba;
        ansb = bb;
      } else if (mind.compareTo(d) == 0){
        if (ansa.compareTo(ba) > 0) {
          ansa = ba;
          ansb = bb;
        } else if (ansa.compareTo(ba) == 0) {
          if (ansb.compareTo(bb) > 0) {
            ansa = ba;
            ansb = bb;
          }
        }
      }

      return;
    }

    char aa = a.charAt(i);
    char bb = b.charAt(i);
    if (c == 0) {
      if (aa != '?' && bb != '?') {
        if (aa == bb) {
          doit(i + 1, 0, a, b);
        } else {
          if (aa > bb) {
            doit(i + 1, 1, a, b);
          } else {
            doit(i + 1, -1, a, b);
          }
        }
      } else {
        if (aa == '?' && bb == '?') {
          doit(i + 1, 0, a.substring(0, i) + '0' + a.substring(i + 1), b.substring(0, i) + '0' + b.substring(i + 1));
          doit(i + 1, 1, a.substring(0, i) + '1' + a.substring(i + 1), b.substring(0, i) + '0' + b.substring(i + 1));
          doit(i + 1, -1, a.substring(0, i) + '0' + a.substring(i + 1), b.substring(0, i) + '1' + b.substring(i + 1));
        } else if (aa != '?') {
          doit(i + 1, 0, a, b.substring(0, i) + aa + b.substring(i + 1));
          if (aa > '0') doit(i + 1, 1, a, b.substring(0, i) + (char)(aa - 1) + b.substring(i + 1));
          if (aa < '9') doit(i + 1, -1, a, b.substring(0, i) + (char)(aa + 1) + b.substring(i + 1));
        } else {
          doit(i + 1, 0, a.substring(0, i) + bb + a.substring(i + 1), b);
          if (bb < '9') doit(i + 1, 1, a.substring(0, i) + (char)(bb + 1) + a.substring(i + 1), b);
          if (bb > '0') doit(i + 1, -1, a.substring(0, i) + (char)(bb - 1) + a.substring(i + 1), b);
        }
      }
    } else if (c == 1) {
      if (aa == '?') {
        a = a.substring(0, i) + '0' + a.substring(i + 1);
      }
      if (bb == '?') {
        b = b.substring(0, i) + '9' + b.substring(i + 1);
      }
      doit(i + 1, c, a, b);
    } else {
      if (aa == '?') {
        a = a.substring(0, i) + '9' + a.substring(i + 1);
      }
      if (bb == '?') {
        b = b.substring(0, i) + '0' + b.substring(i + 1);
      }
      doit(i + 1, c, a, b);
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {

    String a = in.next(), b = in.next();
    String oa = a, ob = b;
    mind = new BigInteger("999999999999999999999999");

    int l = a.length();

    doit(0, 0, a, b);

    String aa = ansa.toString();
    String bb = ansb.toString();
    while (aa.length() < l) aa = '0' + aa;
    while (bb.length() < l) bb = '0' + bb;

    out.printf("Case #%d: %s %s\n", testNumber, aa, bb);
  }
}
