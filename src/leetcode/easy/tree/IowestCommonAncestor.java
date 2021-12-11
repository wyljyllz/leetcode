package leetcode.easy.tree;

import leetcode.dao.TreeNode;

import java.util.*;

/**
 * @ClassName IowestCommonAncestor
 * @Description TODO最近公共祖先
 * @Author wyl
 * @Data
 */
public class IowestCommonAncestor {
    /**
     * @description:二叉搜索树，两次遍历
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = getPath(root, p);
        List<TreeNode> path_q = getPath(root, q);
        TreeNode ancestor = null;
        for (int i = 0; i < path_p.size() && i < path_q.size(); ++i) {
            if (path_p.get(i) == path_q.get(i)) {
                ancestor = path_p.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<TreeNode>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        path.add(node);
        return path;
    }

    /**
     * @description:一次遍历，利用二叉搜索树的性质
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    public TreeNode lowestCommonAncestor01(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }

    //------------------------------------------------------------------------------------------
    /**
     * @description:二叉树的公共祖先
     * @author: 卫依伦
     * @date: 2021/11/28
     */
    class Solution {

        private TreeNode ans;

        public Solution() {
            this.ans = null;
        }
        /**
         * @description:递归
         * @author: 卫依伦
         * @date: 2021/11/28
         */
        private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return false;
            boolean lson = dfs(root.left, p, q);
            boolean rson = dfs(root.right, p, q);
            if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
                ans = root;
            }
            return lson || rson || (root.val == p.val || root.val == q.val);
        }

        public TreeNode lowestCommonAncestorOfCom(TreeNode root, TreeNode p, TreeNode q) {
            this.dfs(root, p, q);
            return this.ans;
        }

        /**
         * @description:存储父节点
         * @author: 卫依伦
         * @date: 2021/11/28
         */
        Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
        Set<Integer> visited = new HashSet<Integer>();

        public void dfs01(TreeNode root) {
            if (root.left != null) {
                parent.put(root.left.val, root);
                dfs01(root.left);
            }
            if (root.right != null) {
                parent.put(root.right.val, root);
                dfs01(root.right);
            }
        }

        public TreeNode lowestCommonAncestorOfCom01(TreeNode root, TreeNode p, TreeNode q) {
            dfs01(root);
            while (p != null) {
                visited.add(p.val);
                p = parent.get(p.val);
            }
            while (q != null) {
                if (visited.contains(q.val)) {
                    return q;
                }
                q = parent.get(q.val);
            }
            return null;
        }
    }

}
