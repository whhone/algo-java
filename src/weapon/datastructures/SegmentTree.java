package weapon.datastructures;

/**
 * Add Point. Query Range.
 *
 * // Construct the segment tree.
 * SegmentTree smt = new SegmentTree(-1000, 1000);
 *
 * // Add from value to from position.
 * smt.add(pos, value);
 *
 * // Query the sum of from range.
 * int count  = smt.query(left, right);
 */
public class SegmentTree {

  class Node {
    int left, right, middle, count;
    Node leftNode, rightNode;

    public Node(int left, int right) {
      this.left = left;
      this.right = right;
      this.middle = (int)(left + ((long)right - (long)left) / 2);
      this.leftNode = null;
      this.rightNode = null;
    }
  }

  Node root;

  public SegmentTree(int leftMost, int rightMost) {
    this.root = new Node(leftMost, rightMost);
  }

  public void add(int x, int value) {
    add(this.root, x, value);
  }

  private void add(Node root, int x, int value) {
    if (root.left == root.right) {
      root.count += value;
    } else {
      if (x <= root.middle) {
        if (root.leftNode == null) {
          root.leftNode = new Node(root.left, root.middle);
        }
        add(root.leftNode, x, value);
      } else {
        if (root.rightNode == null) {
          root.rightNode = new Node(root.middle + 1, root.right);
        }
        add(root.rightNode, x, value);
      }

      root.count = 0;
      if (root.leftNode != null) {
        root.count += root.leftNode.count;
      }
      if (root.rightNode != null) {
        root.count += root.rightNode.count;
      }
    }
  }

  public int query(int left, int right) {
    return query(root, left, right);
  }

  private int query(Node root, int left, int right) {
    if (root == null) {
      return 0;
    }
    if (root.left == left && root.right == right) {
      return root.count;
    } else {
      int count = 0;
      if (left <= root.middle) {
        count += query(root.leftNode, left, Math.min(root.middle, right));
      }
      if (right > root.middle) {
        count += query(root.rightNode, Math.max(root.middle + 1, left), right);
      }
      return count;
    }
  }
}
