package leetcode.medium.tree;

import leetcode.dao.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName PruneTree
 * @Description 二叉树剪枝
 * @Author wyl
 * @Data
 */
public class PruneTree {
    /**
     * @description:递归，后序遍历思想
     * @author: 卫依伦
     * @date: 2021/12/8
     */
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null) return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1) node.left = null;
        if (!a2) node.right = null;
        return node.val == 1 || a1 || a2;
    }

    public TreeNode pruneTree01(TreeNode root) {
        if (root == null) return null;

        root.left = pruneTree(root.left);   // 左子树剪枝，得到剪枝后左子树
        root.right = pruneTree(root.right); // 右子树剪枝，得到剪枝后右子树
        // 判断决定root结点是否需要剪掉：
        if (root.left == null && root.right == null && root.val == 0) return null;
        // 返回root这棵树剪枝后的结果
        return root;
    }
    /**
     * @description:栈实现后序遍历
     * @author: 卫依伦
     * @date: 2021/12/8
     */
    public TreeNode pruneTree02(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<TreeNode> mark = new LinkedList<>(); //使用辅助栈
        TreeNode node = root;
        while(node != null || !stack.isEmpty()){
            while(node != null){ //一直入栈
                stack.push(node);
                node = node.left;
            }
            while(!mark.isEmpty() && mark.peek() == stack.peek()){
                TreeNode cur = stack.pop();
                if(mark.pop().val == 0 && cur.left == null
                        && cur.right == null){ //符合条件时
                    if(!stack.isEmpty()){
                        TreeNode tmp = stack.peek();
                        if(tmp.left == cur){
                            tmp.left = null;
                        }else{
                            tmp.right = null;
                        }
                    } else{
                        return null;
                    }
                }
            }
            if(!stack.isEmpty()){
                node = stack.peek();
                mark.push(node);
                node = node.right;
            }
        }
        return root;
    }

    public TreeNode pruneTree03(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        TreeNode pre = null;
        while(node != null || !stack.isEmpty()){
            while(node != null){ //一直入栈
                stack.push(node);
                node = node.left;
            }
            TreeNode cur = stack.pop();
            if (cur.right == null || cur.right == pre){ //判断是否有右孩子以及右孩子是否访问过
                pre = cur;
                node = null;
                if(cur.val == 0 && cur.left == null
                        && cur.right == null){ //符合条件时
                    if(!stack.isEmpty()){
                        TreeNode tmp = stack.peek();
                        if(tmp.left == cur){
                            tmp.left = null;
                        }else{
                            tmp.right = null;
                        }
                    } else{
                        return null;
                    }
                }
            } else {
                stack.push(cur);
                node = cur.right;
            }
        }
        return root;
    }


}
