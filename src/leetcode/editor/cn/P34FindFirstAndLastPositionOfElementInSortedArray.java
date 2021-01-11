//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 799 👎 0


package leetcode.editor.cn;
//Java：在排序数组中查找元素的第一个和最后一个位置

/**
 * 对左右边界分别进行处理,采用二分思想
 */
public class P34FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void getLeft(int[] nums, int[] arr, int target, int start, int end) {
        if (start > end) {
            return ;
        }
        if (start == end) {
            arr[0] = nums[start] == target ? start : -1;
            return ;
        }
        int mid = (start + end) / 2;
        if (target <= nums[mid]) {
            end = mid;
        } else {
            start = mid + 1;
        }
        getLeft(nums, arr, target, start, end);
    }
    private void getRight(int[] nums, int[] arr, int target, int start, int end) {
        if (start > end) {
            return ;
        }
        if (start == end) {
            arr[1] = nums[start] == target ? start : -1;
            return ;
        }
        int mid = (start + end + 1) / 2;
        if (target < nums[mid]) {
            end = mid - 1;
        } else {
            start = mid;
        }
        getRight(nums, arr, target, start, end);
    }
    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        getLeft(nums, arr, target, 0, nums.length - 1);
        getRight(nums, arr, target, 0, nums.length - 1);
        return arr;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}