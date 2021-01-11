//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 
// 👍 5487 👎 0


package leetcode.editor.cn;

import com.rjh.enerties.ListNode;
//Java：两数相加

/**
 * 两个链表长短可能不一样,可以创建一个头结点存结果数据,且默认指向长的那一条链表
 * 运算过程为 : 进位,余位
 */
public class P2AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new P2AddTwoNumbers().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        final int MOD = 10;
        int sum = 0;
        ListNode l1Node = l1;
        ListNode l2Node = l2;
        while (l1 != null && l2 != null) {
            sum += l1.val + l2.val;
            l1.val = sum % MOD;
            l2.val = l1.val;
            l1 = l1.next;
            l2 = l2.next;
            sum /= MOD;
        }
        ListNode lNode = l1 == null ? l2Node : l1Node;
        ListNode l = l1 == null ? l2 : l1;
        while (l != null) {
            sum += l.val;
            l.val = sum % MOD;
            l = l.next;
            sum /= MOD;
        }
        ListNode l3 = lNode;
        if (sum > 0) {
            while (lNode.next != null) {
                lNode = lNode.next;
            }
            lNode.next = new ListNode(sum);
        }
        return l3;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}