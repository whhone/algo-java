package workspace;

import weapon.datastructures.SegmentTree;
import utils.InputReader;
import utils.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TaskD {

  class XLine {
    int x, y1, y2, type;

    public XLine(int type, int x, int y1, int y2) {
      this.type = type;
      this.x = x;
      this.y1 = Math.min(y1, y2);
      this.y2 = Math.max(y1, y2);
    }
  }

  class Operation {
    int type, eventPoint, x1, x2;
    public Operation(int type, int eventPoint, int x1, int x2) {
      this.type = type;
      this.eventPoint = eventPoint;
      this.x1 = x1;
      this.x2 = x2;
    }
  }

  final protected static Comparator<Operation> CmpO = new Comparator<Operation>() {
    public int compare(Operation a, Operation b) {
      if (a.eventPoint != b.eventPoint) {
        return a.eventPoint - b.eventPoint;
      } else {
        return a.type - b.type;
      }
    }
  };

  final protected static Comparator<XLine> CmpB = new Comparator<XLine>() {
    public int compare(XLine a, XLine b) {
      if (a.x != b.x) {
        return a.x - b.x;
      } else {
        return a.y1 - b.y1;
      }
    }
  };

  public void merge(ArrayList<XLine> lines) {
    Collections.sort(lines, CmpB);

    int j = 1;
    while (j < lines.size()) {
      XLine a = lines.get(j);
      XLine p = lines.get(j-1);
      if (a.x == p.x && a.y1 <= p.y2) {
        p.y2 = Math.max(p.y2, a.y2);
        lines.remove(j);
      } else {
        ++j;
      }
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int N = in.nextInt();
    ArrayList<XLine> xLines = new ArrayList<XLine>();
    ArrayList<XLine> yLines = new ArrayList<XLine>();
    for (int i = 0; i < N; ++i) {
      int[] a = in.nextIntArray(4);
      if (a[0] == a[2]) {
        xLines.add(new XLine(-1, a[0], a[1], a[3]));
      } else {
        yLines.add(new XLine(1, a[1], a[0], a[2]));
      }
    }

    merge(xLines);
    merge(yLines);
    long ans = 0;
    ArrayList<Operation> operations = new ArrayList<Operation>();
    for (XLine line : xLines) {
      // Query
      operations.add(new Operation(2, line.x, line.y1, line.y2));
      ans += line.y2 - line.y1 + 1;
    }
    for (XLine line : yLines) {
      // Add / Remove Point
      operations.add(new Operation(0, line.y1, line.x, 0));
      operations.add(new Operation(4, line.y2, line.x, 0));
      ans += line.y2 - line.y1 + 1;
    }


    Collections.sort(operations, CmpO);
    SegmentTree sgt = new SegmentTree(-1000000000, 1000000000);

    for (Operation o : operations) {
      if (o.type == 2) {
        ans -= sgt.query(o.x1, o.x2);
      } else if (o.type == 0) {
        sgt.add(o.x1, 1);
      } else {
        sgt.add(o.x1, -1);
      }
    }
    out.println(ans);
  }
}
