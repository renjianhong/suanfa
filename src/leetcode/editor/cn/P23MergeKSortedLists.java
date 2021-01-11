//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 堆 链表 分治算法 
// 👍 1079 👎 0


package leetcode.editor.cn;

import com.rjh.enerties.ListNode;

import java.util.PriorityQueue;

//Java：合并K个升序链表

/**
 * 对题目经行分析,输入的链表数组为升序排列且要求合并为一个,故可以想到每次都要找到一个最小的数,放入结果链表后面即可
 * 为了找到链表数组中头结点最小的,我们可以以链表数组头结点数组为根据来一次循环找到最下的节点,进行操作,但这样就会导致时间复杂度很高,且每次都浪费
 * 很多,因为每次找到一个后,头结点数组都是大致有序的,只存在一对结点是不符合的,故此每次只需要对一个结点维护即可,很简单就可以想到小根堆,同样可以用
 * 优先队列来实现
 */
public class P23MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
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
    public ListNode mergeKLists(ListNode[] lists) {
        //用lambda表达式创建一个优先队列会更加的简洁
        PriorityQueue<ListNode> priQueue = new PriorityQueue<>((ListNode list1, ListNode list2) -> (list1.val < list2.val ? -1 : 1));
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            priQueue.add(list);
        }
        ListNode head = new ListNode();
        ListNode root = head;
        while (priQueue.size() > 0) {
            ListNode p = priQueue.poll();
            head.next = p;
            head = head.next;
            if (p.next != null) {
                priQueue.add(p.next);
            }
        }
        return root.next;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}