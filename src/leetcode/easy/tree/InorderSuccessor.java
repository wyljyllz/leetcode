package leetcode.easy.tree;

import leetcode.dao.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName InorderSuccessor
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class InorderSuccessor {
    /**
     * @description:遍历
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // 记录当前比 p 节点大的节点
        TreeNode ans = null;
        // 在二叉搜索树中进行搜索
        while(root != null){
            // 如果当前节点 > p，则更新当前比 p 节点大的节点 ans , 同时去左子树进行搜索
            if(root.val > p.val){
                ans = root;
                root = root.left;
            }else{// 如果当前节点 < p , 则到右子树进行搜索
                root = root.right;
            }
        }
        // 当搜寻结束后，ans 保存的就是最近的比 p 节点大的节点。
        return ans;
    }

    /**
     * @description:递归，中序遍历
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    List<TreeNode> list = new LinkedList<>();

    public TreeNode inorderSuccessor01(TreeNode root, TreeNode p) {
        inorder(root);
        if (list.indexOf(p) + 1 == list.size()) return null;
        return list.get(list.indexOf(p) + 1);
    }

    //因为是二叉搜索树，所以中序遍历后节点值大小一定是从小到大
    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        list.add(node);
        inorder(node.right);
    }


}
