package leetcode.easy.array;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName FindMinDifference
 * @Description 最小时间差
 * @Author wyl
 * @Data
 */
public class FindMinDifference {
    /**
     * @description:排序
     * @author: 卫依伦
     * @date: 2021/12/7
     */
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[][] time = new int[len][2];
        int i = 0;
        for(String s : timePoints){
            time[i][0] = Integer.parseInt(s.substring(0,2));
            time[i++][1] = Integer.parseInt(s.substring(3));
        }
        Arrays.sort(time,(a, b)->{//排序
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
        int minute = 1440;
        for(i=1; i<len; i++){  //比较
            int num = 0;
            num += ((time[i][0] - time[i-1][0])*60);
            num += (time[i][1] - time[i-1][1]);
            if(num == 0) return 0;
            minute = Math.min(minute,num);
        }
        return Math.min(minute,((time[0][0] + 24 - time[len-1][0])*60) + (time[0][1] - time[len-1][1]));
    }

    /**
     * @description:排序
     * @author: 卫依伦
     * @date: 2021/12/7
     */
    public int findMinDifference02(List<String> timePoints) {
        int n=timePoints.size();
        if(n>1440){
            return 0;
        }
        int[] times=new int[n];
        // 将时间全部转化为分钟
        for(int i=0;i<n;i++){

            String m=timePoints.get(i).substring(0,2);
            String s=timePoints.get(i).substring(3,5);
            times[i]=Integer.parseInt(m)*60+Integer.parseInt(s);
        }
        int result=Integer.MAX_VALUE;
        Arrays.sort(times);
        for(int i=1;i<n;i++){
            result = Math.min((times[i] - times[i - 1]),result);

        }
        return Math.min(result,times[0] - times[n - 1] + 1440);

    }
}
