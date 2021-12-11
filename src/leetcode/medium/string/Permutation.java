package leetcode.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Permutation
 * @Description 输入一个字符串，打印出该字符串中字符的所有排列。
 * @Author wyl
 * @Data
 */
public class Permutation {
    /**
     * @description:回溯
     * @author: 卫依伦
     * @date: 2021/11/24
     */
        List<String> rec;
        boolean[] vis;

        public String[] permutation(String s) {
            int n = s.length();
            rec = new ArrayList<String>();
            vis = new boolean[n];
            char[] arr = s.toCharArray();
            Arrays.sort(arr);//排序保证相同的字符都相邻
            StringBuffer perm = new StringBuffer();
            backtrack(arr, 0, n, perm);
            int size = rec.size();
            String[] recArr = new String[size];
            for (int i = 0; i < size; i++) { //ArrayList转为String[]
                recArr[i] = rec.get(i);
            }
            return recArr;
        }

        public void backtrack(char[] arr, int i, int n, StringBuffer perm) {
            if (i == n) {
                rec.add(perm.toString());
                return;
            }
            for (int j = 0; j < n; j++) {
                if (vis[j] || (j > 0 && !vis[j - 1] && arr[j - 1] == arr[j])) {
                    continue;
                }
                vis[j] = true;
                perm.append(arr[j]);
                backtrack(arr, i + 1, n, perm);
                perm.deleteCharAt(perm.length() - 1);//撤销
                vis[j] = false;
            }
        }

        /**
         * @description:下一个排列
         * @author: 卫依伦
         * @date: 2021/11/24
         */
        class Solution {
            public String[] permutation(String s) {
                List<String> ret = new ArrayList<String>();
                char[] arr = s.toCharArray();
                Arrays.sort(arr);
                do {
                    ret.add(new String(arr));
                } while (nextPermutation(arr));
                int size = ret.size();
                String[] retArr = new String[size];
                for (int i = 0; i < size; i++) {
                    retArr[i] = ret.get(i);
                }
                return retArr;
            }

            public boolean nextPermutation(char[] arr) {
                int i = arr.length - 2;
                while (i >= 0 && arr[i] >= arr[i + 1]) {
                    i--;
                }
                if (i < 0) {
                    return false;
                }
                int j = arr.length - 1;
                while (j >= 0 && arr[i] >= arr[j]) {
                    j--;
                }
                swap(arr, i, j);
                reverse(arr, i + 1);
                return true;
            }

            public void swap(char[] arr, int i, int j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            public void reverse(char[] arr, int start) {
                int left = start, right = arr.length - 1;
                while (left < right) {
                    swap(arr, left, right);
                    left++;
                    right--;
                }
            }
        }
}
