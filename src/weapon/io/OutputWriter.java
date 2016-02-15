package weapon.io;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class OutputWriter extends PrintWriter {

  public OutputWriter(OutputStream stream) {
    super(stream);
  }

  public OutputWriter(Writer writer) {
    super(writer);
  }

  public void printlnIntArray(int[] arr, char separator) {
    for (int i = 0; i < arr.length; ++i) {
      print(arr[i]);
      print(separator);
    }
    println();
  }
}
