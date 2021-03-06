package leetcode.medium.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName FindMaximumXOR
 * @Description 数组中两个数的最大异或值
 * @Author wyl
 * @Data
 */
public class FindMaximumXOR {
    /**
     * @description:哈希表报存前缀，
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    static final int HIGH_BIT = 30;
    public int findMaximumXOR(int[] nums) {
        int x = 0;
        // 将所有的 pre^k(a_j) 放入哈希表中
        for (int k = HIGH_BIT; k >= 0; --k) {
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                seen.add(num >> k);
            }
            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int xNext = x * 2 + 1;
            boolean found = false;

            //枚举 i
            for (int num : nums) {
                if (seen.contains(xNext ^ (num >> k))) {
                    found = true;
                    break;
                }
            }
            if (found) {
                x = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                x = xNext - 1;
            }
        }
        return x;
    }

    /**
     * @description:放入字典树，进行枚举
     * 枚举a_i,将a_1,a_2,a_3.....a_i-1放入字典树
     * @author: 卫依伦
     * @date: 2021/11/30
     */
    // 字典树的根节点
    Trie root = new Trie();

    public int findMaximumXOR01(int[] nums) {
        int n = nums.length;
        int x = 0;
        for (int i = 1; i < n; ++i) { //秒
            // 将 nums[i-1] 放入字典树，此时 nums[0 .. i-1] 都在字典树中
            add(nums[i - 1]);
            // 将 nums[i] 看作 ai，找出最大的 x 更新答案
            x = Math.max(x, check(nums[i]));
        }
        return x;
    }

    public void add(int num) { //放入字典树
        Trie cur = root;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                if (cur.left == null) {
                    cur.left = new Trie();
                }
                cur = cur.left;
            }
            else {
                if (cur.right == null) {
                    cur.right = new Trie();
                }
                cur = cur.right;
            }
        }
    }

    public int check(int num) {
        Trie cur = root;
        int x = 0;
        for (int k = HIGH_BIT; k >= 0; --k) {
            int bit = (num >> k) & 1;
            if (bit == 0) {
                // a_i 的第 k 个二进制位为 0，应当往表示 1 的子节点 right 走，0异或1为1
                if (cur.right != null) {
                    cur = cur.right;
                    x = x * 2 + 1;
                } else {
                    cur = cur.left;
                    x = x * 2;
                }
            } else {
                // a_i 的第 k 个二进制位为 1，应当往表示 0 的子节点 left 走
                if (cur.left != null) {
                    cur = cur.left;
                    x = x * 2 + 1;
                } else {
                    cur = cur.right;
                    x = x * 2;
                }
            }
        }
        return x;
    }
class Trie {
    // 左子树指向表示 0 的子节点
    Trie left = null;
    // 右子树指向表示 1 的子节点
    Trie right = null;
}
}
