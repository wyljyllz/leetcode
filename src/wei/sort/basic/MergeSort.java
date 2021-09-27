package wei.sort.basic;

/**
 * @ClassName MergeSort
 * @Description TODO
 * @Author wyl
 * @Data
 */
public abstract class MergeSort<T extends Comparable<T>> extends sort<T> {
    protected T[] aux;
    protected void merge(T[] nums, int l, int m , int h) {
        int i = l;
        int j = m + 1;

        for (int k = l; k <= h; k++) {
            aux[k] = nums[k];
        }

        for (int k = l; k <= h; k++) {
            if (i > m) {
                nums[k] = aux[i++];
            } else if (j > h) {
                nums[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                nums[k] = nums[i++];
            } else {
                nums[k] = nums[j++];
            }
        }
    }
}
