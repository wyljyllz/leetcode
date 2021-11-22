package leetcode.medium.array;

/**
 * @ClassName Exist
 * 矩阵中的路径
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Exist {
    /**
     * @description:DFS+剪枝  回溯
     * @author: 卫依伦
     * @date: 2021/11/19
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        //终止条件
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0'; //修改为 空字符 '' ，代表此元素已访问过，防止之后搜索时重复访问,重复访问时肯定不相等，为' '.
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];//修正，还原至初始值
        return res;
    }

    /**
     * @description:回溯
     * @author: 卫依伦
     * @date: 2021/11/19
     */
    public boolean exist01(char[][] board, String word) {
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[i].length; j++)
                if(dfs(board,word,0,i,j)) return true;
        return false;
    }
    int[] dx = new int[]{-1,0,1,0}, dy = new int[]{0,1,0,-1};
    boolean dfs(char[][] board, String word,int u,int x,int y)
    {
        if(board[x][y] != word.charAt(u)) return false;
        if(u == word.length() - 1)   return true;
        char t = board[x][y];
        board[x][y] = '.';
        for(int i = 0; i < 4; i++)
        {
            int a = x + dx[i], b = y + dy[i];
            if(a < 0 || a >= board.length|| b < 0 || b >= board[0].length || board[a][b] == '.')  continue;
            if(dfs(board,word,u+1,a,b)) return true;
        }
        board[x][y] = t;
        return false;
    }

}
