package leetcode.easy.tree;

import leetcode.dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName MirrorTree
 * @Description TODO树的镜像
 * @Author wyl
 * @Data
 */
public class MirrorTree {
    /**
     * @description:递归
     * @author: 卫依伦
     * @date: 2021/11/22
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.left = left;
        return root;
    }

    /**
     * @description:迭代,使用栈
     * @author: 卫依伦
     * @date: 2021/11/22
     */
    public TreeNode mirrorTree01(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.pop();
            if (node.left != null) {
                treeNodes.push(node.left);
            }
            if (node.right != null) {
                treeNodes.push(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
    /**
     * @description:使用队列
     * @author: 卫依伦
     * @date: 2021/11/22
     */
    public TreeNode mirrorTree03(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.poll();
            if (node.left != null) {
                treeNodes.add(node.left);
            }
            if (node.right != null) {
                treeNodes.add(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
