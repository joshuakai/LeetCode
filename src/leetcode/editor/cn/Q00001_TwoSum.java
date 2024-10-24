package leetcode.editor.cn;

import java.util.HashMap;

public class Q00001_TwoSum {

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution {
    public int[] twoSum(int[] nums, int target) {
      HashMap<Integer, Integer> valueToIndexMap = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int num1 = nums[i];
        Integer num2 = valueToIndexMap.get(target - num1);
        if (num2 != null) {
          return new int[] {num2, i};
        }
        valueToIndexMap.put(num1, i);
      }
      return new int[0];
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
