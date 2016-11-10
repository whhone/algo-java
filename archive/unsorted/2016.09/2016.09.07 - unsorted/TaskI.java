package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class TaskI {

  class Node {
    char c;
    Node prev, next;

    Node(char c) {
      this.c = c;
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int T = in.nextInt();
    while (T-- > 0) {
      String s = in.next();
      Node root = new Node('.');
      Node cur = root;

      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);

        if (c == '<') {
          if (cur.prev != null) {
            cur = cur.prev;
          }
        } else if (c == '>') {
          if (cur.next != null) {
            cur = cur.next;
          }
        } else if (c == '-') {
          if (cur.prev != null) {
            Node next = cur.next;
            cur = cur.prev;
            cur.next = next;
            if (next != null) {
              next.prev = cur;
            }
          }
        } else {
          Node n = new Node(c);
          n.next = cur.next;
          n.prev = cur;
          cur.next = n;
          cur = n;

          if (n.next != null) {
            n.next.prev = n;
          }
        }
      }
      if (root.next != null) root = root.next;
      while (root != null) {
        out.print(root.c);
        root = root.next;
      }
      out.println();
    }
  }
}
