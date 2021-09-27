package wei.sort.basic;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ShellSort <T extends Comparable<T>> extends sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        int h = 1;
        while(h < N / 3) {
            h = 3 * h + 1;
        }

        while(h >= 1) {
            for (int i = h; i < N ; i++){//把h当成1就是插入排序
                for (int j = i; j >= h && less(nums[j],nums[j-h]);j -=h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }
}
