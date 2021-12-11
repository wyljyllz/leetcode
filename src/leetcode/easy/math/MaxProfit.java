package leetcode.easy.math;

/**
 * @ClassName MaxProfit
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class MaxProfit {
    /**
     * @description:用一个变量记录一个历史最低价格 minprice
     * @author: 卫依伦
     * @date: 2021/11/29
     */
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

}
