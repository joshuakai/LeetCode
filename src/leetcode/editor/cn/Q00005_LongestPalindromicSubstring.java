package leetcode.editor.cn;

/**
 * 给你一个字符串 s，找到 s 中最长的 回文 子串。
 *
 * <p>提示： 1 <= s.length <= 1000 s 仅由数字和英文字母组成 Related Topics 双指针 字符串 动态规划
 */
public class Q00005_LongestPalindromicSubstring {
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution extends DynamicProgrammingSolution {}

  class CenterExpandSolution {
    public String longestPalindrome(String s) {
      if (s == null || s.length() < 1) return "";
      int start = 0;
      int end = 0;
      for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i); // Odd length palindromes
        int len2 = expandAroundCenter(s, i, i + 1); // Even length palindromes
        int len = Math.max(len1, len2);
        if (len > end - start) {
          start = i - (len - 1) / 2;
          end = i + len / 2;
        }
      }
      return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
      }
      return right - left - 1;
    }
  }

  class DynamicProgrammingSolution {
    public String longestPalindrome(String s) {
      if (s == null || s.length() < 1) return "";
      int len = s.length();
      int n = 2 * len + 1;
      char[] t = new char[n];
      int[] p = new int[n];
      int center = 0;
      int right = 0;
      int maxLen = 0;
      int index = 0;

      for (int i = 0; i < n; i++) {
        t[i] = (i & 1) == 0 ? '#' : s.charAt(i / 2);
      }

      for (int i = 0; i < n; i++) {
        int mirror = 2 * center - i;
        if (right > i) {
          p[i] = Math.min(right - i, p[mirror]);
        }
        while (i + p[i] + 1 < n && i - p[i] - 1 >= 0 && t[i + p[i] + 1] == t[i - p[i] - 1]) {
          p[i]++;
        }
        if (i + p[i] > right) {
          center = i;
          right = i + p[i];
        }
        if (p[i] > maxLen) {
          maxLen = p[i];
          index = i;
        }
      }

      int start = (index - maxLen) / 2;
      return s.substring(start, start + maxLen);
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
