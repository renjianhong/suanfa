//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1068 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：全排列

/**
 * 回溯
 */
public class P46Permutations{
    public static void main(String[] args) {
        Solution solution = new P46Permutations().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void back(List<List<Integer>> res, List<Integer> list, int[] vis, int[] nums) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] == 1) {
                continue;
            }
            vis[i] = 1;
            list.add(nums[i]);
            back(res, list, vis, nums);
            list.remove(list.size() - 1);
            vis[i] = 0;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(res, new ArrayList<>(), new int[nums.length], nums);
        return res;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}