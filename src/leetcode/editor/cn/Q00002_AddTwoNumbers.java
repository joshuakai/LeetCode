package leetcode.editor.cn;

public class Q00002_AddTwoNumbers {

  // leetcode submit region begin(Prohibit modification and deletion)
  class Solution extends SolutionLoop {}

  class SolutionRecursion {
    public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
      ListNode currentNode = new ListNode(0);
      ListNode preNode = currentNode;
      addNodes(currentNode, node1, node2, 0);
      return preNode.next;
    }

    public void addNodes(ListNode resultNode, ListNode node, int carry) {
      int sum = node.val + carry;
      carry = sum / 10;
      resultNode.next = new ListNode(sum % 10);
      if (node.next != null) {
        addNodes(resultNode.next, node.next, carry);
      } else if (carry == 1) {
        resultNode.next.next = new ListNode(carry);
      }
    }

    public void addNodes(ListNode resultNode, ListNode node1, ListNode node2, int carry) {
      int sum = node1.val + node2.val + carry;
      carry = sum / 10;
      resultNode.next = new ListNode(sum % 10);
      boolean isNode1NextNull = node1.next == null;
      boolean isNode2NextNull = node2.next == null;
      if (isNode1NextNull && isNode2NextNull) {
        if (carry == 1) {
          resultNode.next.next = new ListNode(carry);
        }
      } else if (!isNode1NextNull && !isNode2NextNull) {
        addNodes(resultNode.next, node1.next, node2.next, carry);
      } else if (isNode1NextNull) {
        addNodes(resultNode.next, node2.next, carry);
      } else if (isNode2NextNull) {
        addNodes(resultNode.next, node1.next, carry);
      }
    }
  }

  class SolutionLoop {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode pre = new ListNode(0);
      ListNode cur = pre;
      int carry = 0;
      while (l1 != null || l2 != null) {
        int x = l1 == null ? 0 : l1.val;
        int y = l2 == null ? 0 : l2.val;
        int sum = x + y + carry;
        carry = sum / 10;
        sum = sum % 10;
        cur.next = new ListNode(sum);
        cur = cur.next;

        if (l1 != null) l1 = l1.next;
        if (l2 != null) l2 = l2.next;
      }
      if (carry == 1) {
        cur.next = new ListNode(carry);
      }
      return pre.next;
    }
  }

  // leetcode submit region end(Prohibit modification and deletion)

  void printPrefix(ListNode cur, String prefix) {
    System.out.print(prefix);
    print(cur);
  }

  void print(ListNode cur) {
    System.out.print(cur.val);
    if (cur.next != null) {
      print(cur.next);
    } else {
      System.out.println("");
    }
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      return val + (next == null ? "" : next.toString());
    }
  }
}
