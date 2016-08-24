package weapon.lab;

import java.util.Arrays;
import java.util.Random;

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

  public static void shuffleArray(int[] arr) {
    int n = arr.length;
    Random rnd = new Random();
    for (int i = 0; i < n; i++) {
      int tmp = arr[i];
      int randomPos = i + rnd.nextInt(n - i);
      arr[i] = arr[randomPos];
      arr[randomPos] = tmp;
    }
  }

  /**
   * Shuffle the array before calling Quick Sort to avoid worst-time.
   */
  public static void sort(int[] arr) {
    shuffleArray(arr);
    Arrays.sort(arr);
  }
}
