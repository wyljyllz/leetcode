package leetcode.easy.tree;

import leetcode.dao.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName MaxDepthOfN
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MaxDepthOfN {
    /**
     * @description:深度优先搜索
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxChildDepth = 0;
        List<Node> children = root.children;
        for (Node child : children) {
            int childDepth = maxDepth(child);
            maxChildDepth = Math.max(maxChildDepth,childDepth);
        }
        return maxChildDepth + 1;
    }
    /**
     * @description:广度优先搜索
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int maxDepth01(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node node = queue.poll();
                List<Node> children = node.children;
                for (Node child : children) {
                    queue.offer(child);
                }
                size--;
            }
            ans++;//层数加一
        }
        return ans;
    }
}
