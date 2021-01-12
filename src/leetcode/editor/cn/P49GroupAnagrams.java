//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 625 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：字母异位词分组

/**
 * 采用哈希表,把访问过得字符串存起来,为了方便比较,我把字符串重新换个形式拼接,用字符+个数来组成新的字符串,然后依次循环就可以遍历了
 */
public class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        String[] strs = new String[len];
        for (int i = 0; i < len; i++) {
            strs[i] = scanner.nextLine();
        }
        solution.groupAnagrams(strs);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private String getOrderlyString(String str) {
        StringBuffer sb = new StringBuffer();
        int[] charArr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charArr[str.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == 0) {
                continue;
            }
            sb.append((char) (i + 'a'));
            sb.append(charArr[i]);
        }
        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            String orderStr = getOrderlyString(str);
            int i = map.getOrDefault(orderStr, -1);
            if (i != -1) {
                res.get(i).add(str);
                continue;
            }
            List<String> list = new ArrayList<>();
            list.add(str);
            res.add(list);
            map.put(orderStr, res.size() - 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}