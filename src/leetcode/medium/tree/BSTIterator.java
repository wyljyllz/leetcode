package leetcode.medium.tree;

import leetcode.dao.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName BSTIterator
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class BSTIterator {
    /**
     * @description:对二叉搜索树做一次完全的递归遍历，获取中序遍历的全部结果并保存在数组中
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    private int idx;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        idx = 0;
        arr = new ArrayList<Integer>();
        inorderTraversal(root, arr);
    }

    public int next() {
        return arr.get(idx++);
    }

    public boolean hasNext() {
        return idx < arr.size();
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }

    /**
     * @description:利用栈
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    class BSTIterator01 {
        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator01(TreeNode root) {
            cur = root;
            stack = new LinkedList<TreeNode>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;//下次右孩子遍历入栈，循环往复 右子树又是先左后根 再右
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

    /**
     * @description:把树变成单链，只需要一个额外的引用，构造时时间复杂度O(n), 调用时O(1), 空间复杂度O(1)
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    class BSTIterator02 {
        TreeNode list = null;
        public BSTIterator02(TreeNode root) {
            parseTree(root);
        }

        private void parseTree(TreeNode node){
            if (node.right != null){
                parseTree(node.right);
            }
            node.right = list;
            list = node;
            if (node.left != null){
                parseTree(node.left);
            }
        }

        public int next() {
            int val = list.val;
            list = list.right;
            return val;
        }

        public boolean hasNext() {
            return list != null;
        }
    }
}
