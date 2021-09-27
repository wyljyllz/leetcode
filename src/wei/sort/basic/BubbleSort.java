package wei.sort.basic;

/**
 * @ClassName 冒泡排序
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class BubbleSort<T extends Comparable<T>> extends sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean isSort = false;
        for (int i = N - 1; i > 0 && !isSort; i--) {
            isSort = true;
            for(int j = 0; j < i; j++){
                if(less(nums[j+1], nums[j])){
                    isSort = false;
                    swap(nums, j , j+1);
                }
            }
        }
    }
    /**
     * @description:设置边界和flag
     * @author: 卫依伦
     * @date: 2021/9/26
     */
    public void sort1(T[] nums){
        int flag = 1;
        int len = nums.length;
        while(flag > 0){
            flag = 0;
            for(int i = 1; i < len; i++){
                if (less(nums[i], nums[i-1])){
                    swap(nums, i , i-1);
                    flag = i;
                }
            }
            len = flag;
        }
    }
}
