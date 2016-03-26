package weapon.datastructures;

/**
 * Range Query and Range Update. Zero-based.
 */
public class ExtendedBIT {

  int N;
  long[] a1, a2;

  public ExtendedBIT(int N) {
    this.N = N;
    this.a1 = new long[N + 1];
    this.a2 = new long[N + 1];
  }

  public void add(int from, int to, long value) {
    ++from; ++to;
    long value2 = value * (to + 1);
    for (int i = to + 1; i <= this.N; i += i & -i) {
      a1[i] -= value;
      a2[i] -= value2;
    }
    value2 = value * from;
    for (int i = from; i <= this.N; i += i & -i) {
      a1[i] += value;
      a2[i] += value2;
    }
  }

  public long query(int from, int to) {
    ++from; ++to;
    long sum = 0;
    for (int i = to; i > 0; i -= i & -i) {
      sum += a1[i] * (to + 1);
      sum -= a2[i];
    }
    for (int i = from - 1; i > 0; i -= i & -i) {
      sum -= a1[i] * from;
      sum += a2[i];
    }
    return sum;
  }
}
