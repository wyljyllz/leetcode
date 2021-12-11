package leetcode.easy.tree;

import leetcode.dao.TreeNode;

/**
 * @ClassName SearchBST
 * @Description 二叉搜索树的查找
 * @Author wyl
 * @Data
 */
public class SearchBST {
    /**
     * @description:递归
     * @author: 卫依伦
     * @date: 2021/11/26
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        return searchBST(val < root.val ? root.left : root.right, val);
    }

    /**
     * @description:迭代
     * @author: 卫依伦
     * @date: 2021/11/26
     */
    public TreeNode searchBST01(TreeNode root, int val) {
        while (root != null) {
            if (val == root.val) {
                return root;
            }
            root = val < root.val ? root.left : root.right;
        }
        return null;
    }

}
