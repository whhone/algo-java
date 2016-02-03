package workspace;

import io.InputReader;
import weapon.Mos;

import java.io.*;

// http://codeforces.com/contest/86/problem/D
public class Task {

  int N, T;
  int[] a;
  int[] cnt;
  Mos mos;

  public long diff(int a) {
    long count = (long)cnt[a];
    return ((long) a) * (2 * count + 1);
  }

  public void solve(int testNumber, InputReader in, PrintWriter out) {
    // InputReader in = new InputReader(System.in);

    N = in.nextInt();
    T = in.nextInt();
    a = new int[N + 1];
    cnt = new int[1000005];

    mos = new Mos(N, T) {

      @Override
      public void rightRight() {
        curRight++;
        curAns += diff(a[curRight]);
        cnt[a[curRight]]++;
      }

      @Override
      public void rightLeft() {
        cnt[a[curRight]]--;
        curAns -= diff(a[curRight]);
        curRight--;
      }

      @Override
      public void leftRight() {
        cnt[a[curLeft]]--;
        curAns -= diff(a[curLeft]);
        curLeft++;
      }

      @Override
      public void leftLeft() {
        curLeft--;
        curAns += diff(a[curLeft]);
        cnt[a[curLeft]]++;
      }
    };

    for (int i = 1; i <= N; ++i) {
      a[i] = in.nextInt();
    }

    for (int i = 0; i < T; ++i) {
      mos.setQuery(i, in.nextInt(), in.nextInt());
    }

    mos.exec();

    for (int i = 0; i < T; ++i) {
      out.println(mos.getAnswer(i));
    }
  }


}
