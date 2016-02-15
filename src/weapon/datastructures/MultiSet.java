package weapon.datastructures;

import java.util.HashMap;
import java.util.Set;

/**
 * A MultiSet for T.
 */
public class MultiSet<T> {
  HashMap<T, Integer> hm;

  public MultiSet() {
    hm = new HashMap<T, Integer>();
  }

  public void add(T object) {
    add(object, 1);
  }

  public void add(T object, int occurrences) {
    if (contains(object)) {
      hm.put(object, hm.get(object) + occurrences);
    } else {
      hm.put(object, occurrences);
    }
  }

  public boolean contains(T object) {
    return hm.containsKey(object);
  }

  public void clear() {
    hm.clear();
  }

  public Set<T> elementSet() {
    return hm.keySet();
  }

  public void remove(T object) {
    remove(object, 1);
  }

  public void remove(T object, int occurrences) {
    int count = count(object);
    if (count <= occurrences) {
      hm.remove(object);
    } else {
      hm.put(object, count - occurrences);
    }
  }

  public int count(T object) {
    if (hm.containsKey(object)) {
      return hm.get(object);
    } else {
      return 0;
    }
    // getOrDefault() is available since Java 8.
    // return hm.getOrDefault(object, 0);
  }

  public int size() {
    return hm.size();
  }
}
