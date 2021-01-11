//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1110 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：组合总和

/**
 * 排序后,回溯剪枝
 * 为了不重复,我们可以知道前面用过的,下一次不可以再次使用,和三数四叔相加思想基本一致
 */
public class P39CombinationSum{
    public static void main(String[] args) {
        Solution solution = new P39CombinationSum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void back(List<List<Integer>> res, List<Integer> list, int target, int start, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return ;
        }
        for (int i = start; i < candidates.length; i++) {
            //在这里进行判断,条件成立则后续都可以不用进行,减去了代码的冗余
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
            back(res, list, target - candidates[i], i, candidates);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        back(res, new ArrayList<>(), target, 0, candidates);
        return res;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}