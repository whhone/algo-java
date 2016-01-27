package workspace;

import weapon.Mos;

import java.util.Scanner;
import java.io.PrintWriter;


public class TaskE {

  int N, M, K;
  int[] a;
  int[] sum;
  int[] cnt;

  public void solve(int testNumber, Scanner in, PrintWriter out) throws Exception {
    N = in.nextInt();
    M = in.nextInt();
    K = in.nextInt();
    a = new int[N + 1];
    sum = new int[N + 1];
    cnt = new int[2000020];

    Mos mos = new Mos(N, M) {
      @Override
      public void rightRight() {
        curRight++;
        curAns += cnt[sum[curRight] ^ K];
        cnt[sum[curRight]]++;
      }

      @Override
      public void rightLeft() {
        cnt[sum[curRight]]--;
        curAns -= cnt[sum[curRight] ^ K];
        curRight--;
      }

      @Override
      public void leftRight() {
        cnt[sum[curLeft]]--;
        curAns -= cnt[sum[curLeft] ^ K];
        curLeft++;
      }

      @Override
      public void leftLeft() {
        curLeft--;
        curAns += cnt[sum[curLeft] ^ K];
        cnt[sum[curLeft]]++;
      }
    };

    for (int i = 1; i <= N; ++i) {
      a[i] = in.nextInt();
      sum[i] = sum[i - 1] ^ a[i];
    }

    for (int i = 0; i < M; ++i) {
      mos.setQuery(i, in.nextInt() - 1, in.nextInt());
    }

    mos.exec();

    for (int i = 0; i < M; ++i) {
      out.println(mos.getAnswer(i));
    }
  }
}
