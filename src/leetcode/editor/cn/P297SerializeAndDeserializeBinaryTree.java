//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 示例: 
//
// 你可以将以下二叉树：
//
//    1
//   / \
//  2   3
//     / \
//    4   5
//
//序列化为 "[1,2,3,null,null,4,5]" 
//
// 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这
//个问题。 
//
// 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。 
// Related Topics 树 设计 
// 👍 444 👎 0


package leetcode.editor.cn;

import com.rjh.enerties.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//Java：二叉树的序列化与反序列化

/**
 * 序列化,由于在节点为空时填入了特殊字符,故此在建树时可以根据一个遍历结果就可以成功创建,故只需选择任一遍历,且在遍历结果为空时填入NULL即可
 * 在遍历结果后处理字符串,去除后面多余的NULL
 * 反序列化同样如此
 */
public class P297SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
        Codec solution = new P297SerializeAndDeserializeBinaryTree().new Codec();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String SEP = ",";
    private static final String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode pNode = root;
        nodes.offer(pNode);
        while (!nodes.isEmpty()) {
            pNode = nodes.poll();
            if (pNode == null) {
                sb.append(NULL);
                sb.append(SEP);
                continue ;
            }
            sb.append(pNode.val);
            nodes.offer(pNode.left);
            nodes.offer(pNode.right);
            sb.append(SEP);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuilder sb = new StringBuilder(data);
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);
        if (sb.length() == 0) {
            return null;
        }
        String[] nodes = sb.toString().split(SEP);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        TreeNode p = root;
        nodeQueue.offer(p);
        for (int i = 1; i < nodes.length;) {
            p = nodeQueue.poll();
            String son = nodes[i++];
            if (!NULL.equals(son)) {
                p.left = new TreeNode(Integer.parseInt(son));
                nodeQueue.offer(p.left);
            }
            son = nodes[i++];
            if (!NULL.equals(son)) {
                p.right = new TreeNode(Integer.parseInt(son));
                nodeQueue.offer(p.right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}