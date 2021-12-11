package leetcode.medium.tree;

import java.util.Stack;

/**
 * @ClassName VerifyPostorder
 * @Description 剑指offer33
 * 判断该数组是不是某二叉搜索树的后序遍历结果
 * @Author wyl
 * @Data
 */
public class VerifyPostorder {
    /**
     * @description:递归分治
     * 判断所有子树是否是二叉搜索树，以后序方式模拟
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        if (i >= j) return true;//节点小于等于1
        int p = i;
        while (postorder[p] < postorder[j]) p++;//找到根节点
        int mid = p;
        while (postorder[p] > postorder[j]) p++;
        return p == j && recur(postorder, i, mid - 1) && recur(postorder, mid, j - 1);//判断左子树和右子树
    }

    /**
     * @description:单调栈，利用二叉搜索树后序遍历倒序
     * 例如【5，6，2，3，1】
     * @author: 卫依伦
     * @date: 2021/11/24
     */

    public boolean verifyPostorder01(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root) return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

}
