package leetcode.easy.tree;

import leetcode.dao.TreeNode;

/**
 * @ClassName IsSymmetric
 * @Description TODO是否是对称二叉树
 * @Author wyl
 * @Data
 */
public class IsSymmetric {
    /**
     * @description:终止条件，递进关系
     * @author: 卫依伦
     * @date: 2021/11/22
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }
    boolean recur(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

}
