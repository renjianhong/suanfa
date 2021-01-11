//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1125 👎 0


package leetcode.editor.cn;
//Java：最长有效括号

/**
 * 字符串从后向前遍历,依次维护当前下标最长有效括号的长度,则下一个位置就可以根据当前位置来进行动态规划的判断
 */
public class P32LongestValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P32LongestValidParentheses().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length(), max = 0;
        if (s == null || len == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[len - 1] = 0;
        dp[len] = 0;
        for (int i = len - 2; i >  -1; i--) {
            if (s.charAt(i) == ')') {
                dp[i] = 0;
                continue;
            }
            if (s.charAt(i + 1) == ')') {
                dp[i] = dp[i + 2] + 2;
            } else {
                int index = i + dp[i + 1] + 1;
                dp[i] = (index == len || s.charAt(index) == '(') ? 0 : dp[i + 1] + 2 + dp[index + 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}