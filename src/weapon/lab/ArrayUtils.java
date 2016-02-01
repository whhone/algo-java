package weapon.lab;

public class ArrayUtils {

  public static int findIntArrayMinIndex(int[] a) {
    int minIndex = 0;
    for (int i = 1; i < a.length; ++i) {
      if (a[i] < a[minIndex]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  public static int findIntArrayMin(int[] a) {
    return a[findIntArrayMinIndex(a)];
  }

  public static int findIntArrayMaxIndex(int[] a) {
    int minIndex = 0;
    for (int i = 1; i < a.length; ++i) {
      if (a[i] > a[minIndex]) {
        minIndex = i;
      }
    }
    return minIndex;
  }

  public static int findIntArrayMax(int[] a) {
    return a[findIntArrayMaxIndex(a)];
  }

  public static long sumIntArray(int[] a) {
    int sum = 0;
    for (int i : a) {
      sum += i;
    }
    return sum;
  }
}
