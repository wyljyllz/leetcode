package leetcode.medium.array.dfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MovingCount机器人走格子，求位数和，分障碍物和非障碍物
 * 深度搜索和广度搜索
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MovingCount {
    /**
     * @description:广度搜索
     * 通过队列，每一对角线为一层
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int movingCount(int m, int n, int k) {
        if (k == 0)
            return 1;
        Queue<int[]> queue = new LinkedList<>();
        //向左向右的方向数组
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] vis = new boolean[m][n]; // 用于标记是否访问过
        queue.offer(new int[] {0, 0});
        vis[0][0] = true;
        int ans = 1;
        while (!queue.isEmpty()) { //队列不为空，一层（对角线）
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for (int i = 0; i < 2; i++) {
                int tx = dx[i] + x;
                int ty = dy[i] + y;
                if (tx < 0 || tx >= m || ty < 0 || ty >= n || vis[tx][ty] || get(tx) + get(ty) > k) {
                    continue;//通过条件跳出本次循环
                }
                queue.offer(new int[] {tx, ty});//放入队列
                vis[tx][ty] = true;//进行标记
                ans++;
            }
        }
        return ans;
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
        /**
         * @description:递推
         * @author: 卫依伦
         * @date: 2021/11/21
         */
        public int movingCount01(int m, int n, int k){
            if (k == 0) {
                return 1;
            }
            boolean[][] vis = new boolean[m][n];
            int ans = 1;
            vis[0][0] = true;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                        continue;
                    }
                    // 边界判断
                    if (i - 1 >= 0) {
                        vis[i][j] |= vis[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        vis[i][j] |= vis[i][j - 1];
                    }
                    ans += vis[i][j] ? 1 : 0;
                }
            }
            return ans;
        }

    /**
     * @description:深度搜索
     * @author: 卫依伦
     * @date: 2021/11/21
     */
    public int movingCount02(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }
    public int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        if(i >= m || j >= n || k < get(i) + get(j) || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k, visited) + dfs(i, j + 1, m, n, k, visited);
    }

}
