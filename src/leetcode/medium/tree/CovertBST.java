package leetcode.medium.tree;

import leetcode.dao.TreeNode;

/**
 * @ClassName CovertBST
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class CovertBST {
    /**
     * @description:反序中序遍历
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    /**
     * @description:Morris 遍历
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public TreeNode convertBST01(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }


}
