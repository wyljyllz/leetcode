package leetcode.easy.tree;

import leetcode.dao.TreeNode;

import java.util.*;

/**
 * @ClassName FindTarget
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class FindTarget {
    /**
     * @description:HashSet
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public boolean findTarget(TreeNode root, int k) {
        Set< Integer > set = new HashSet();
        return find(root, k, set);
    }
    public boolean find(TreeNode root, int k, Set < Integer > set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return find(root.left, k, set) || find(root.right, k, set);
    }

    /**
     * @description:BFS+HashSet
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public boolean findTarget01(TreeNode root, int k) {
        Set < Integer > set = new HashSet();
        Queue< TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;
    }

    /**
     * @description:转为数组
     * @author: 卫依伦
     * @date: 2021/12/10
     */
    public boolean findTarget02(TreeNode root, int k) {
        List< Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


}
