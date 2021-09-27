package wei.sort.basic;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class InsertSort<T extends Comparable<T>> extends sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for(int i = 1; i < N; i++){
            for(int j = i; j > 0 && less(nums[j], nums[j-1]); j-- ){
                swap(nums, j, j-1);
            }
        }
    }
}
