package leetcode.medium.tree;

import leetcode.dao.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName CBTInserter
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class CBTInserter {
    /**
     * @description:双端队列
     * @author: 卫依伦
     * @date: 2021/12/7
     */
    TreeNode root;
    Deque<TreeNode> deque;
    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);

        // BFS to populate deque
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();//取出并删除队头的元素，当队列为空,返回null;
            if (node.left == null || node.right == null)
                deque.offerLast(node);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = deque.peekFirst();//检索但不删除此列表的第一个元素，如果此列表为空，则返回null。
        deque.offerLast(new TreeNode(v));//将元素添加在列表的末尾
        if (node.left == null)
            node.left = deque.peekLast();
        else {
            node.right = deque.peekLast();
            deque.pollFirst();//删除
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }


}
