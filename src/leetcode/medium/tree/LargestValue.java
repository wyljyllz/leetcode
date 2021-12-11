package leetcode.medium.tree;

import leetcode.dao.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LargestValue
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class LargestValue {

    /**
     * @description:dfs
     * @author: 卫依伦
     * @date: 2021/12/8
     */
    //保存对应层数的最大值，第一层的最大值在索引为0处，第二层在1处
    private List<Integer> list = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root,1);
        return list;
    }
    //深度遍历
    private void dfs(TreeNode node, int depth){
        if(node == null){
            return;
        }
        //如果当前层数还没有添加过值，就默认当前值是当前层数最大的值
        //如果当前层已经有最大值，就取出当前层最大值和当前值比较，如果当前值更大就更新对应层数的最大值
        if(depth > list.size()){ //第一次深度时才符合
            list.add(node.val);
        }else if(depth <= list.size()){ //后面的都小与size
            int max = list.get(depth-1);
            max = node.val > max ? node.val : max;
            list.set(depth-1,max);
        }
        //继续递归左右子树
        dfs(node.left,depth+1);//两者绑定
        dfs(node.right,depth+1);
    }

    /**
     * @description:层次遍历
     * @author: 卫依伦
     * @date: 2021/12/8
     */
    public List<Integer> largestValues01(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // 层序遍历
        while (!q.isEmpty()) {
            int sz = q.size();
            // 在每一层维护一个变量，用于存储最大值
            int max = Integer.MIN_VALUE;
            // 对每一层的元素进行遍历
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 每取出来一个元素就进行一次比较
                max = Math.max(max, cur.val);

                // 添加下一层的元素
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            // 将每一层的最大值添加到结果变量中
            result.add(max);
        }
        return result;
    }

}
