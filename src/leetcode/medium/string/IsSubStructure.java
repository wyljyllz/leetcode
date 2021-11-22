package leetcode.medium.string;

import leetcode.dao.TreeNode;

/**
 * @ClassName IsSubStructure
 * 判断树B是否是树A的子树
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class IsSubStructure {

    /**
     * @description:对称性递归
     * 先定位找到节点，再判断是否子树
     * @author: 卫依伦
     * @date: 2021/11/22
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) { //判断子树
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    /**
     * @description:详细写法
     * @author: 卫依伦
     * @date: 2021/11/22
     */
    public boolean isSubStructure01(TreeNode A, TreeNode B) {
        if (B == null || A == null)
            return false;
        if (helper(A, B)) {
            return true;
        }
        return isSubStructure01(A.left, B) || isSubStructure01(A.right, B);
    }

    private boolean helper(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null) {
            return false;
        }
        if (A.val == B.val) {
            return helper(A.left, B.left) && helper(A.right, B.right);
        } else {
            return false;
        }
    }
}
