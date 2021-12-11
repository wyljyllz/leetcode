package leetcode.easy.tree;

import leetcode.dao.TreeNode;

/**
 * @ClassName KthLargest
 * @Description 二叉搜索树的第k大元素
 * @Author wyl
 * @Data
 */
public class KthLargest {
    int count=0, res=0;//形参k不能随着dfs的迭代而不断变化，为了记录迭代进程和结果，引入类变量count和res。
    public int kthLargest(TreeNode root, int k) {
        this.count=k;//利用形参值k对类变量count进行初始化
        dfs(root);//这里不要引入形参k，dfs中直接使用的是初始值为k的类变量count
        return res;
    }
    public void dfs(TreeNode root){
        if(root==null||count==0) return;//当root为空或者已经找到了res时，直接返回
        dfs(root.right);
        if(--count==0){//先--，再判断
            res = root.val;
            return;//这里的return可以避免之后的无效迭代dfs(root.left);
        }
        dfs(root.left);
    }

}
