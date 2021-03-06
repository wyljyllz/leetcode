package leetcode.easy.tree;

import leetcode.dao.TreeNode;

/**
 * @ClassName IsBalanced
 * @Description 判断是否是平衡二叉树
 * @Author wyl
 * @Data
 */
public class IsBalanced {

    /**
     * @description:自顶向下递归
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    /**
     * @description:自底向上递归，
     * @author: 卫依伦
     * @date: 2021/11/27
     */
    public boolean isBalanced01(TreeNode root) {
        return height01(root) >= 0;
    }

    public int height01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

}

