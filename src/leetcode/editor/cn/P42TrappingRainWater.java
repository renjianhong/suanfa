//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 
// 👍 1930 👎 0


package leetcode.editor.cn;
//Java：接雨水

/**
 * 找出最高点,从左右边界一次想最高点的下标逼近,遇到较小点维护sum结果,遇到较大点则维护当前高度
 * 也可以使用动态规划,双指针
 */
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > height[maxIndex]) {
                maxIndex = i;
            }
        }
        int heightNow = height[0];
        int count = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (heightNow < height[i]) {
                heightNow = height[i];
                continue;
            }
            count += heightNow - height[i];
        }
        heightNow = height[height.length - 1];
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (heightNow < height[i]) {
                heightNow = height[i];
                continue;
            }
            count += heightNow - height[i];
        }
        return count;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}