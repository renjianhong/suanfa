//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 字符串 动态规划 回溯算法 
// 👍 1782 👎 0


package leetcode.editor.cn;
//Java：正则表达式匹配

/**
 * 从题目中可以知道,.匹配任一字符,*匹配程度和前一位有关,故,我只需要对*特殊讨论就可以,而*可以匹配的字符不是固定的,因此要是用循环来逐个比较,但是
 * 这样的复杂度会比较高,所以可以采取逐个消去的思想,一次只匹配一个,使用动态规划可以得到解决
 */
public class P10RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private boolean charEquals(String s, String p, int i, int j) {
        if (i < 0) {
            return false;
        }
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }
    public boolean isMatch(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        final boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int i = 0; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = charEquals(s, p, i - 1, j - 2) ? dp[i - 1][j] || dp[i][j - 2] : dp[i][j - 2];
                    continue;
                }
                dp[i][j] = charEquals(s, p, i - 1, j - 1) ? dp[i - 1][j - 1] : false;
            }
        }
        return dp[sLen][pLen];
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}