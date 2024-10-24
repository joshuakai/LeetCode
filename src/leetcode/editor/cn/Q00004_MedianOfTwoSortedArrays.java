package leetcode.editor.cn;

public class Q00004_MedianOfTwoSortedArrays {
  // leetcode submit region begin(Prohibit modification and deletion)

  /**
   * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 算法的时间复杂度应该为 O(log (m+n)) 。
   *
   * <p>nums1.length == m nums2.length == n 0 <= m <= 1000 0 <= n <= 1000 1 <= m + n <= 2000 -106 <=
   * nums1[i], nums2[i] <= 106
   */
  class Solution extends SolutionTwoPointers {}

  class SolutionTwoPointers {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int totalLength = nums1.length + nums2.length;
      int point1 = 0;
      int point2 = 0;
      int valLeft = 0;
      int valRight = 0;

      for (int i = 0; i <= totalLength / 2; i++) {
        valLeft = valRight;
        if (point2 >= nums2.length || (point1 < nums1.length && nums1[point1] <= nums2[point2])) {
          valRight = nums1[point1++];
        } else {
          valRight = nums2[point2++];
        }
      }

      if (totalLength % 2 == 1) {
        valLeft = valRight;
      }

      return (valLeft + valRight) / 2.0;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

}
