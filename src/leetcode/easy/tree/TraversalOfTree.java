package leetcode.easy.tree;

import leetcode.dao.TreeNode;

import java.util.*;

/**
 * @ClassName TraversalOfTree
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class TraversalOfTree {
    /**
     * @description:中序，迭代，使用栈
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    public List<Integer> inorderTravelsal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }
    public List<Integer> inorderTraversal01(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
    /**
     * @description:中序，递归
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
//----------------------------------------------------------------------------------------------------------------------
    /**
     * @description:前序遍历，递归
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    public List<Integer> preorderTravelsal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }
    private void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);//添加元素
        preorder(root.left, res);
        preorder(root.right, res);
    }

    /**
     * @description:迭代，前序
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    public List<Integer> preorderTravelsal01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {//左孩子一直入栈
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
    /**
     * @description:前序，栈,迭代,ArrayList
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    public List<Integer> preorderTravelsal02(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            res.add(temp.val);
            if (temp.right != null) { //右节点先入栈
                stack.push(temp.right);
            }
            if (temp.left != null) { //左节点入栈
                stack.push(temp.left);
            }
        }
        return res;
    }
//----------------------------------------------------------------------------------------------------------------------

    /**
     * @description:后序遍历，递归
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    public List<Integer> postorderTravelsal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        postorder(root, res);
        return res;
    }
    private void postorder(TreeNode root, LinkedList<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    /**
     * @description:后序遍历，迭代
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    public List<Integer> postorderTravelsal01(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {//访问过，上一个访问的节点是右子节点，此时可以访问当前节点
                res.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }

    /**
     * @description:后序，栈，linkedList
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    public List<Integer> postorderTravelsal03(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root == null) {
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.push(node.val);//头插法
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return res;
    }
//----------------------------------------------------------------------------------------------------------------------
    /**
     * @description:二叉树的层次遍历,使用队列
     * @author: 卫依伦
     * @date: 2021/11/3
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();//队列长度
            for (int i = 1; i <=currentLevelSize; i++) { //同一层全出队列
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
