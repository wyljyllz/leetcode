package leetcode.medium.tree;

import leetcode.dao.TreeNode;

import java.util.*;

public class PathSum {
    /**
     * @ClassName PathSum路径总和
     * @Description 找出是否存在从根节点root到叶子节点（左右子树）路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     * @Author wyl
     * @Data
     */

    /**
     * @description:广度搜索
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<TreeNode>();
        Queue<Integer> queVal = new LinkedList<Integer>();
        queNode.offer(root);
        queVal.offer(root.val);
        while (!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == sum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }
        }
        return false;
    }

    /**
     * @description:递归
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    public boolean hasPathSum01(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }



//---------------------------------------------------------------------------------------
    /**
     * @ClassName PathSum
     * @Description 找出所有从根节点root到叶子节点（左右子树）路径总和等于给定目标和的路径。
     * 叶子节点 是指没有子节点的节点。
     * @Author wyl
     * @Data
     */
    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }
    /**
     * @description:dfs一次遍历/回溯
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        targetSum -= root.val;
        if (root.left == null && root.right == null && targetSum == 0) { //保证到叶子节点
            ret.add(new LinkedList<Integer> (path));
        }
        dfs(root.left, targetSum);
        dfs(root.right,targetSum);
        path.pollLast();//剪枝
    }

    /**
     * @description:广度优先搜索
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    Map<TreeNode, TreeNode> map = new HashMap<>();//使用哈希表记录树中的每一个节点的父节点
    public List<List<Integer>> pathSum01(TreeNode root, int targetSum) {
        if (root == null)
            return ret;
        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);
        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;
            if (node.left == null && node.right == null) {
                if (rec == targetSum) {
                    getPath(node);
                }
            } else {
                    if (node.left != null) {
                        map.put(node.left, node);
                        queueNode.offer(node.left);
                        queueSum.offer(rec);
                    }
                    if (node.right != null) {
                        map.put(node.right, node);
                        queueNode.offer(node.right);
                        queueSum.offer(rec);
                    }
                }
            }
        return ret;
    }

    public void getPath(TreeNode node) { //得到路径
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);//返回父节点，map(left/right,root)
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }
//---------------------------------------------------------------------------------------
    /**
     * @ClassName PathSum
     * @Description 求该二叉树里节点值之和等于 targetSum的路径的数目。有重复性计算
     * 叶子节点 是指没有子节点的节点。
     * @Author wyl
     * @Data
     */
    public int pathSumOfAll(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSumOfAll(root.left, targetSum);
        ret += pathSumOfAll(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    /**
     * @description:前缀和，回溯
     * 利用先序遍历二叉树，记录下根节点 root 到当前节点 pp 的路径上除当前节点以外所有节点的前缀和，
     * 在已保存的路径前缀和中查找是否存在前缀和刚好等于当前节点到根节点的前缀和 currcurr 减去targetSum。
     *减少重复计算
     * @author: 卫依伦
     * @date: 2021/11/24
     */
    public int pathSumOfAll01(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);//包括根节点的路径刚好为targetSum
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        curr += root.val;
        ret = prefix.getOrDefault(curr - targetSum, 0);//获取指定 key 对应对 value,如果找不到 key ,则返回设置的默认值
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);//更新
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);// 当子树结束时，应当把子树从哈希表中移除 (回溯：将一切复原，然后结束)。
        return ret;
    }


}
