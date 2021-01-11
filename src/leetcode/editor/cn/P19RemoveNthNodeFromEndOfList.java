//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 
// 👍 1171 👎 0


package leetcode.editor.cn;

import com.rjh.enerties.ListNode;

//Java：删除链表的倒数第N个节点

/**
 * 一次循环删除倒数第N的节点
 * 基本思想为定义两个节点中间相差为n,故第一个节点循环到末尾时,第二个节点即为结果
 */
public class P19RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new P19RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode font = new ListNode();
        ListNode root = font;
        font.next = head;
        while (pre != null) {
            pre = pre.next;
            if (n-- > 0) {
                continue;
            }
            font = font.next;
        }
        font.next = font.next.next;
        return root.next;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}