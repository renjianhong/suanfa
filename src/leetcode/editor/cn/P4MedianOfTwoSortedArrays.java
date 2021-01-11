//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3590 👎 0


package leetcode.editor.cn;
//Java：寻找两个正序数组的中位数

/**
 * 二分
 * 已知两个数组是正序的,且知中位数性质,故了解要找出第(m+n+1)/2得数,且求得的中位数应该是不小于前一位,不大于后一位,再考虑好左边界和右边界即可
 *
 */
public class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        if (len1 > len2) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int start = 0, end = len1;
        while (start <= end) {
            int i = (start + end) / 2;
            int j = (len1 + len2 + 1) / 2 - i;
            if (i != 0 && j != len2 && arr1[i - 1] > arr2[j]) {
                end = i - 1;
            } else if (j != 0 && i != len1 && arr1[i] <arr2[j - 1]) {
                start = i + 1;
            } else {
                int left = 0, right = 0;
                if (i == 0) {
                    left = arr2[j - 1];
                } else if (j == 0) {
                    left = arr1[i - 1];
                } else {
                    left = Math.max(arr1[i -1], arr2[j - 1]);
                }
                final boolean existed = (len1 + len2) % 2 == 1;
                if (existed) {
                    return left * 1.0;
                }
                if (i == len1) {
                    right = arr2[j];
                } else if (j == len2) {
                    right = arr1[i];
                } else {
                    right = Math.min(arr1[i], arr2[j]);
                }
                return (left + right) / 2.0;
            }

        }
        return 0.0;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}