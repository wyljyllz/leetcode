package wei.sort.basic;

import java.util.Arrays;

/**
 * @ClassName HeapSort
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class HeapSort<T extends Comparable<T>> extends sort<T> {
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;
        for (int k = N / 2; k >= 0; k--)
            sink(nums, k, N);

            while (N > 1) {
                swap(nums,0, N--);
                sink(nums, 0, N);
            }

    }

    private void sink(T[] nums, int k, int n) {
        while (2 * k + 2 <= n) {
            int j = 2 * k + 1;
            if (j < n && less(nums, j, j+1))
                j++;
            if(!less(nums, k, j))
                break;
            swap(nums, k, j);
            k = j;
        }

    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }
    public static void main(String []args){
        Integer[] arr = {9,8,7,66,2,1,88,3,2,4,1,884,3,2,1};
        HeapSort<Integer> integerHeapSort = new HeapSort<>();
        integerHeapSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
