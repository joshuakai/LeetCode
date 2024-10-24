package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q00006_ZigzagConversion {

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution extends FastSolution {}

  class FastSolution {
    public String convert(String s, int numRows) {
      if (numRows == 1 || s.length() <= numRows) {
        return s;
      }
      StringBuilder resultSb = new StringBuilder();
      int graphSize = 2 * numRows - 2;
      for (int graphLineIndex = 0; graphLineIndex < numRows; graphLineIndex++) {
        for (int graphLineEle1Index = graphLineIndex;
            graphLineEle1Index < s.length();
            graphLineEle1Index += graphSize) {
          resultSb.append(s.charAt(graphLineEle1Index));
          if (graphLineIndex != 0 && graphLineIndex != numRows - 1) {
            int graphLineEle2Index = graphLineEle1Index + graphSize - 2 * graphLineIndex;
            if (graphLineEle2Index < s.length()) {
              resultSb.append(s.charAt(graphLineEle2Index));
            }
          }
        }
      }
      return resultSb.toString();
    }
  }

  class SlowSolution {
    public String convert(String s, int numRows) {
      int zGraphNum = numRows == 1 ? 1 : (numRows - 1) * 2;
      int middle = zGraphNum / 2;
      List<String> lines = new ArrayList<>();
      for (int i = 0; i < numRows; i++) {
        lines.add("");
      }
      for (int i = 0; i < s.length(); i++) {
        char word = s.charAt(i);
        int zNum = i % zGraphNum;
        int linesIndex = zNum > middle ? middle - (zNum - middle) : zNum;
        lines.set(linesIndex, lines.get(linesIndex) + word);
      }
      return lines.stream().collect(Collectors.joining());
    }
  }

  class SlotBuilderArraySolution {
    public String convert(String s, int numRows) {
      int zGraphNum = numRows == 1 ? 1 : (numRows - 1) * 2;
      int middle = zGraphNum / 2;
      List<String> lines = new ArrayList<>();
      for (int i = 0; i < numRows; i++) {
        lines.add("");
      }
      for (int i = 0; i < s.length(); i++) {
        char word = s.charAt(i);
        int zNum = i % zGraphNum;
        int linesIndex = zNum > middle ? middle - (zNum - middle) : zNum;
        lines.set(linesIndex, lines.get(linesIndex) + word);
      }
      return lines.stream().collect(Collectors.joining());
    }
  }
  // leetcode submit region end(Prohibit modification and deletion)

}
