package leetcode.medium;

import com.sun.deploy.cache.BaseLocalApplicationProperties;
import leetcode.dao.TreeNode;

import java.util.Deque;
import java.util.HashMap;


import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName 根据先序遍历和中序遍历求二叉树
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class myBuildTree {
    private static Map<Integer, Integer> indexMap;

    public static TreeNode buildTree(int[] preorder,int[] inorder) {
        int n = preorder.length;
        //构建哈希表，为了快速找到中序根节点
        indexMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return bulidTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * @description:使用递归，找到中序根节点，左边就是左子树，求左子树的根节点
     * @author: 卫依伦
     * @date: 2021/10/31
     */
    public static TreeNode bulidTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                                     int inorder_left, int inorder_right) {
    if (preorder_left > preorder_right) { //递归终止条件
        return null;
    }
    int preorder_root = preorder_left;//前序遍历的第一个节点就是根节点
    int inorder_root = indexMap.get(preorder[preorder_root]);//从map中找出中序根节点所在位置
        TreeNode root = new TreeNode(preorder[preorder_root]);//构建根节点·
        int size_left_subTree = inorder_root - inorder_left;
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = bulidTree(preorder, inorder, preorder_left + 1,
                preorder_left + size_left_subTree,inorder_left, inorder_root - 1);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = bulidTree(preorder, inorder, preorder_left + size_left_subTree + 1,
                preorder_right, inorder_root + 1, inorder_right);
        return root;
    }
    /**
     * @description:迭代
     * @author: 卫依伦
     * @date: 2021/10/31
     */
    public static TreeNode bulidTree01(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
                int preorderVal = preorder[i];
                TreeNode node = stack.peek();//栈顶元素，起始为root
                if (node.val != inorder[inorderIndex]) {
                    node.left = new TreeNode(preorderVal);//左孩子节点赋值
                    stack.push(node.left);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {//回退
                        node = stack.pop();
                        inorderIndex++;
                    }
                    node.right = new TreeNode(preorderVal);//右孩子节点赋值
                    stack.push(node.right);
                }
        }
        return root;

    }




}
