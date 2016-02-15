package weapon.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * A faster input reader.
 */
public class InputReader {
  public BufferedReader reader;
  public StringTokenizer tokenizer;
  public String cache;

  public InputReader(InputStream stream) {
    reader = new BufferedReader(new InputStreamReader(stream), 32768);
    tokenizer = null;
    cache = null;
  }

  public boolean hasNext() {
    if (cache == null) {
      try {
        cache = nextNoCache();
      } catch (NullPointerException e) {}
    }
    return cache != null;
  }

  private String nextNoCache() {
    while (tokenizer == null || !tokenizer.hasMoreTokens()) {
      tokenizer = new StringTokenizer(nextLine());
    }
    return tokenizer.nextToken();
  }

  public String nextLine() {
    try {
      return reader.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public String next() {
    if (cache != null) {
      String next = cache;
      cache = null;
      return next;
    } else {
      return nextNoCache();
    }
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }

  public double nextDouble() {
    return Double.parseDouble(next());
  }

  public int[] nextIntArray(int n) {
    int[] a = new int[n];
    for (int i = 0; i < n; ++i) {
      a[i] = nextInt();
    }
    return a;
  }

  public int[][] nextIntArray2D(int n, int m) {
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        a[i][j] = nextInt();
      }
    }
    return a;
  }
}
