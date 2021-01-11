package com.rjh.util;

import com.rjh.enerties.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rjh
 * @date 2021/1/10 22:32
 */
public class Serialize {
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
