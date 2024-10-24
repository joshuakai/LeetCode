package leetcode.editor.cn;

public class Q00003_LongestSubstringWithoutRepeatingCharacters {
  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int lengthOfLongestSubstring(String input) {
      int currentLength = 0;
      int currentPositionIndex = 0;
      int maxLength = 0;
      for (int index = 0; index < input.length(); index++) {
        int duplicateIndex = input.indexOf(input.charAt(index), currentPositionIndex);
        boolean isDuplicate = duplicateIndex < index;
        if (!isDuplicate) {
          currentLength++;
        }
        if (currentLength > maxLength) {
          maxLength = currentLength;
        }
        if (isDuplicate) {
          currentLength = index - duplicateIndex;
          currentPositionIndex = duplicateIndex + 1;
        }
      }
      return maxLength;
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)
}
