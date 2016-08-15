package workspace;

import weapon.io.InputReader;
import weapon.io.OutputWriter;

public class B {

  int[] ans;
  int[] cnt;
  boolean done;

  boolean a(String s) {
    for (int i = 0; i < s.length(); i++) {
      cnt[s.charAt(i) - 'A']--;
    }
    boolean ok = true;
    for (int i = 0; i < 26; i++) {
      if (cnt[i] < 0) {
        ok = false;
      }
    }
    for (int i = 0; i < s.length(); i++) {
      cnt[s.charAt(i) - 'A']++;
    }
    return ok;
  }

  boolean used() {
    for (int i = 0; i < 26; i++) {
      if (cnt[i] != 0) return false;
    }
    return true;
  }

  void dfs(int digit) {
    if (digit == 10) {
      return;
    }
    if (used()) {
      done = true;
    }

    String s = "";
    if (digit == 0) {
      s = "ZERO";
    }
    if (digit > 0 && cnt['Z' - 'Z'] > 0) {
      return;
    }
    if (digit == 1) {
      s = "ONE";
    }
    if (digit == 2) {
      s = "TWO";
    }
    if (digit > 2 && cnt['Z' - 'W'] > 0) {
      return;
    }
    if (digit > 2 && cnt['Z' - 'O'] > 0) {
      return;
    }
    if (digit == 3) {
      s = "THREE";
    }
    if (digit == 4) {
      s = "FOUR";
    }
    if (digit > 4 && cnt['Z' - 'R'] > 0) {
      return;
    }
    if (digit > 4 && cnt['Z' - 'U'] > 0) {
      return;
    }
    if (digit == 5) {
      s = "FIVE";
    }
    if (digit == 6) {
      s = "SIX";
    }
    if (digit > 6 && cnt['Z' - 'X'] > 0) {
      return;
    }
    if (digit == 7) {
      s = "SEVEN";
    }

    if (digit > 7 && cnt['Z' - 'V'] > 0) {
      return;
    }
    if (digit > 7 && cnt['Z' - 'S'] > 0) {
      return;
    }
    if (digit == 8) {
      s = "EIGHT";
    }
    if (digit > 8 && cnt['Z' - 'E'] > 0) {
      return;
    }
    if (digit == 9) {
      s = "NINE";
    }

    if (!done && a(s)) {
      ans[digit]++;
      for (int i = 0; i < s.length(); i++) {
        cnt[s.charAt(i) - 'A']--;
      }
      dfs(digit);
      if (!done) {
        ans[digit]--;
        for (int i = 0; i < s.length(); i++) {
          cnt[s.charAt(i) - 'A']++;
        }
      }
    }

    if (!done) {
      dfs(digit + 1);
    }
  }

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.next();
    done = false;
    ans = new int[10];
    cnt = new int[30];
    for (int i = 0; i < s.length(); i++) {
      cnt[s.charAt(i) - 'A']++;
    }

    dfs(0);
    out.printf("Case #%d: ", testNumber);
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < ans[i]; j++) {
        out.printf("%d", i);
      }
    }
    out.println();

  }
}
