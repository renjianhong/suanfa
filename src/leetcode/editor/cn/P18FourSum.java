//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意： 
//
// 答案中不可以包含重复的四元组。 
//
// 示例： 
//
// 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
// 
// Related Topics 数组 哈希表 双指针 
// 👍 712 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：四数之和

/**
 * 解法同三数之和,排序后,两次循环再加上双指针,中间判断是否为重复,在进行剪枝,去除不必要的运算
 * 我采用回溯,但回溯算法复杂度很会高
 * 剪枝思想,判断最小值大于目标值或者最大值小于目标值则进行回溯
 */
public class P18FourSum{
    public static void main(String[] args) {
        Solution solution = new P18FourSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backrack(List<List<Integer>> res, int count, List<Integer> list, int sum, int target, int index, int[] nums) {
        if (count == 4 && sum == target) {
            List<Integer> res1 = new ArrayList<>();
            for (Integer i : list) {
                res1.add(i);
            }
            res.add(res1);
            return;
        }
        if (index >= nums.length || nums.length - index < 4 - count || nums[index] > 0 && sum > target || count == 4 && (sum < target || sum > target)) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backrack(res, count + 1, list, sum + nums[i], target, i + 1, nums);
            list.remove(count);
        }
        return;
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backrack(res, 0, new ArrayList<Integer>(), 0, target, 0, nums);
        return res;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}