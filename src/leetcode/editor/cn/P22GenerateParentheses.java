//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1506 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：括号生成

/**
 * 回溯,剪枝
 * 每次都进行判断,如果满足要求,后续可以生成括号串则进行下去,失败则回溯
 */
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private void backtrack(int count, List<String> list, StringBuilder sb, int sum, int n) {
        if (count == n && sum == 0) {
            list.add(sb.toString());
            return ;
        }
        //这三种情况下生成是失败的
        if (count > n || sum < 0 || sum > n - count) {
            return ;
        }
        for (int i = 0; i < 2; i++) {
            sb.append(i > 0 ? ")" : "(");
            backtrack(count + 1, list, sb, sum + (i > 0 ? -1 : 1), n);
            sb.deleteCharAt(count);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(0, list, new StringBuilder(), 0, n * 2);
        return list;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}