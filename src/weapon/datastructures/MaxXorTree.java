package weapon.datastructures;

/**
 * For problem like <a href="http://codeforces.com/problemset/problem/706/D">CF - 706D</>.
 */
public class MaxXorTree {

  private Node root;
  private int maxBit;

  public MaxXorTree(int maxBit) {
    this.maxBit = maxBit;
    this.root = new Node();
  }

  class Node {
    Node left, right;
    int count;
  }


  public void insert(int value) {
    update(root, value, 1, this.maxBit);
  }

  public void remove(int value) {
    update(root, value, -1, this.maxBit);
  }

  public int query(int value) {
    return query(root, value, this.maxBit);
  }

  private void update(Node node, int value, int diff, int bit) {
    node.count += diff;
    if (bit == -1) return;

    if (node.left == null) {
      node.left = new Node();
    }

    if (node.right == null) {
      node.right = new Node();
    }

    if ((value & (1 << bit)) == 0) {
      update(node.right, value, diff, bit - 1);
    } else {
      update(node.left, value, diff, bit - 1);
    }
  }

  private int query(Node node, int value, int bit) {
    if (bit == -1) {
      return 0;
    }

    if ((value & (1 << bit)) == 0) {
      if (node.left.count > 0) {
        return query(node.left, value, bit - 1) + (1 << bit);
      } else {
        return query(node.right, value, bit - 1);
      }
    } else {
      if (node.right.count > 0) {
        return query(node.right, value, bit - 1);
      } else {
        return query(node.left, value, bit - 1) + (1 << bit);
      }
    }
  }
}
