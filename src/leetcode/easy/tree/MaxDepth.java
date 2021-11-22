package leetcode.easy.tree;

import leetcode.dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MaxDepth二叉树的最大深度
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MaxDepth {
    /**
     * @description:深度优先搜索
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    /**
     * @description:广度优先搜索
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int maxDepth01(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {//一层
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
