package leetcode.easy.tree;

import leetcode.dao.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName IncreasingBST
 * @Description 递增顺序查找树
 * @Author wyl
 * @Data
 */
public class IncreasingBST {
    /**
     * @description:中序遍历之后生成新的树
     * @author: 卫依伦
     * @date: 2021/12/8
     */
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;//虚结点
        for (int value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    public void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    /**
     * @description:中序遍历改变指向
     * @author: 卫依伦
     * @date: 2021/12/8
     */
    private TreeNode resNode;

    public TreeNode increasingBST01(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;//置空
        resNode = node;

        inorder(node.right);
    }


}
