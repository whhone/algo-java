package weapon.math;

/**
 * Represents a Matrix. All values take mod MOD.
 */
public final class Matrix {

  public static long MOD = Integer.MAX_VALUE;
  public static void setMod(long newMod) {
    MOD = newMod;
  }

  public static Matrix getIdentity(int size) {
    Matrix m = new Matrix(size, size);
    for (int i = 0; i < size; i++) {
      m.set(i, i, 1);
    }
    return m;
  }

  public static Matrix fromArray(long[][] arr) {
    Matrix m = new Matrix(arr.length, arr[0].length);
    m.e = arr;
    return m;
  }

  public long[][] e;
  public int n;
  public int m;

  public Matrix(int n, int m) {
    this.e = new long[n][m];
    this.n = n;
    this.m = m;
  }

  @Override
  public boolean equals(Object object) {
    if (object == null) return false;
    if (object.getClass() != this.getClass()) return false;
    Matrix that = (Matrix) object;
    if (this.n != that.n || this.m != that.m) {
      return false;
    } else {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (this.e[i][j] != that.e[i][j]) {
            return false;
          }
        }
      }
      return true;
    }
  }

  @Override
  public String toString() {
    String s = "";
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        s += e[i][j] + " ";
      }
      s += "\n";
    }
    return s;
  }

  public void add(int x, int y, long value) {
    e[x][y] = (e[x][y] + value) % MOD;
  }

  public void set(int x, int y, long value) {
    e[x][y] = value % MOD;
  }

  public long get(int x, int y) {
    return e[x][y];
  }

  public Matrix transpose() {
    Matrix result = new Matrix(this.m, this.n);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result.set(j, i, this.get(i, j));
      }
    }
    return result;
  }

  public Matrix multi(Matrix that) {
    Matrix result = new Matrix(this.n, that.m);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < that.m; j++) {
        long sum = 0;
        for (int k = 0; k < this.m; k++) {
          sum = (sum + this.get(i, k) * that.get(k, j)) % MOD;
        }
        result.set(i, j, sum);
      }
    }

    return result;
  }

  public Matrix power(int k) {
    if (k == 0) {
      return Matrix.getIdentity(this.n);
    } else {
      Matrix val = power(k / 2);
      if (k % 2 == 0) {
        return val.multi(val);
      } else {
        return val.multi(val).multi(this);
      }
    }
  }
}
