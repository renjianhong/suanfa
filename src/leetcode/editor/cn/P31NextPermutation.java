//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 896 👎 0


package leetcode.editor.cn;
//Java：下一个排列

/**
 * 思维题
 */
public class P31NextPermutation{
    public static void main(String[] args) {
        Solution solution = new P31NextPermutation().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void trun(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    private void swap(int[] nums, int i,int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private int getIndex(int[] nums, int start, int end, int val) {
        if (start == end) {
            return start;
        }
        int mid = (start + end + 1) / 2;
        if (val >= nums[mid]) {
            return getIndex(nums, start, mid - 1, val);
        }
        if (mid == nums.length - 1 || nums[mid + 1] <= val) {
            return mid;
        }
        return getIndex(nums, mid + 1, end, val);
    }
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int i = 0;
        for (i = nums.length - 1; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) {
                continue;
            }
            int index = getIndex(nums, i, nums.length - 1, nums[i - 1]);
            swap(nums, i - 1, index);
            break;
        }
        trun(nums, i, nums.length - 1);
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}