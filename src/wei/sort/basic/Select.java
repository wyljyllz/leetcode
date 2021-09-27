package wei.sort.basic;

/**
 * @ClassName 选择排序
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Select<T extends Comparable<T>> extends sort<T> {


    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for(int i = 0; i < N - 1; i++){
            int min = i;
            for(int j = i + 1; j < N; j++){
                if(less(nums[j], nums[min])) {
                    min = j;
                }
            }
            swap(nums,i,min);
        }
    }
}
