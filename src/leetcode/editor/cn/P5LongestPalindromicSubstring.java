//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3083 👎 0


package leetcode.editor.cn;
//Java：最长回文子串

/**
 * 中心扩散:将每一个字符都视为一个中心,从中心扩散查找最长
 * Manacher:用一个数组来维护每个点最长的回文距离
 */
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private char[] manacherString(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            sb.append("#");
        }
        return sb.toString().toCharArray();
    }
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 0) {
            return null;
        }
        char[] charArr = manacherString(s);
        int[] radius = new int[charArr.length];
        int maxIndex = 0, max = Integer.MIN_VALUE;
        int r = -1, c = -1;
        for (int i = 0; i < radius.length; i++) {
            radius[i] = r > i ? Math.min(radius[2 * c - i], r - i + 1) : 1;
            while (i + radius[i] < charArr.length && i - radius[i] > -1) {
                if (charArr[i + radius[i]] != charArr[i - radius[i]]) {
                    break;
                }
                radius[i]++;
            }
            if (i + radius[i]  > r) {
                c = i;
                r = i + radius[i] - 1;
            }
            if (radius[i] > max) {
                max = radius[i];
                maxIndex = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = maxIndex - radius[maxIndex] + 1; i < maxIndex + radius[maxIndex]; i++) {
            if (charArr[i] == '#') {
                continue;
            }
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}