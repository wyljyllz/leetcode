package leetcode.medium.tree;

import leetcode.dao.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName FindBottomLeftValue
 * @Description 二叉树最底层最左边的值
 * @Author wyl
 * @Data
 */
public class FindBottomLeftValue {

    /**
     * @description:DFS
     * @author: 卫依伦
     * @date: 2021/12/8
     */
    int res = 0;   // 结果记录
    int dep = -1;  // 深度记录
    public int findBottomLeftValue(TreeNode root) {
        res = root.val;
        findBottomLeftValue(root, 0);
        return res;
    }

    public void findBottomLeftValue(TreeNode root, int depth) {
        if(root == null) return;
        if (depth >= dep) {
            res = root.val;
            dep = depth;
        }

        // 遍历顺序 需要注意！
        // 先遍历右子树
        findBottomLeftValue(root.right, depth + 1);
        // 再遍历左子树
        findBottomLeftValue(root.left, depth + 1);
    }

    class Solution {
        private int Deep = -1;
        private int value = 0;
        public int findBottomLeftValue(TreeNode root) {
            value = root.val;
            findLeftValue(root,0);
            return value;
        }

        private void findLeftValue (TreeNode root,int deep) {
            if (root == null) return;
            if (root.left == null && root.right == null) {
                if (deep > Deep) {
                    value = root.val;
                    Deep = deep;
                }
            }
            if (root.left != null) findLeftValue(root.left,deep + 1);
            if (root.right != null) findLeftValue(root.right,deep + 1);
        }
    }



    /**
     * @description:层次
     * @author: 卫依伦
     * @date: 2021/12/8
     */
    public int findBottomLeftValue02(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (i == 0) {
                    res = poll.val;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return res;
    }


}
