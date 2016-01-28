package utils;

import java.io.OutputStream;
import java.io.PrintWriter;

public class OutputWriter extends PrintWriter {

  public OutputWriter(OutputStream stream) {
    super(stream);
  }

  public void printlnIntArray(int[] arr, char separator) {
    for (int i = 0; i < arr.length; ++i) {
      print(arr[i]);
      print(separator);
    }
    println();
  }
}
