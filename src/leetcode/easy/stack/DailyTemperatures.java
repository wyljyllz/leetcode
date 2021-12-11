package leetcode.easy.stack;

import java.util.Stack;

/**
 * @ClassName DailyTemperatures
 * @Description TODO数组中元素与下一个比它大的元素之间的距离
 * @Author wyl
 * @Data
 */
public class DailyTemperatures {
    /**
     * @description:栈内存放索引值，通过比较数组索引所在值判断是否出栈
     * 单调栈
     * @author: 卫依伦
     * @date: 2021/11/23
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();//弹出元素
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);//所有元素都入栈，然后符合条件弹出
        }
        return dist;
    }
}
