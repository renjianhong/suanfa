//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4801 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

//Java：无重复字符的最长子串

/**
 * 滑动窗口
 * 存入当前无重复的最长字符串的各个字符的下标,记录当前字符串的左下标,遍历一次,每次维护左边界位置
 * 若在hash表中查到字符且下标不小于左边界,就代表发生重复
 */
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int p = 0, max = 0;
        for (int i = 0; i < chars.length; i++) {
            Integer integer = (Integer)map.get(chars[i]);
            if (integer != null && integer >= p) {
                max = Math.max(max, i - p);
                p = map.get(chars[i]) + 1;
            }
            map.put(chars[i], i);
            if (i == chars.length - 1) {
                max = Math.max(max, i - p + 1);
            }
        }
        return max;
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}