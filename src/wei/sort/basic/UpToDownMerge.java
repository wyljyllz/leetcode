package wei.sort.basic;

/**
 * @ClassName UpToDownMerge递归调用
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class UpToDownMerge<T extends Comparable<T>> extends MergeSort<T> {
    @Override
    public void sort(T[] nums) {
         aux = (T[]) new Comparable[nums.length];

    }
    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = l + (h - l) / 2;
        sort(nums, l, mid);
        sort(nums, mid+1, h);
        merge(nums,l, mid, h);
    }
}
