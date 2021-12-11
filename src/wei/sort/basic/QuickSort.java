package wei.sort.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class QuickSort <T extends Comparable<T>> extends sort<T> {
    @Override
    public void sort(T[] nums) {
        shffle(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void shffle(T[] nums) { //打乱数组顺序
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private int partition(T[] nums, int l, int h) { //切分
        int i = l;
        int j = h + 1;
        T v = nums[l];
        while (true) {
            while(less(nums[++i], v) && i != h);
            while(less(v, nums[--j]) && j != l);
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j); //把基准数放入正确位置
        return j;
    }
    private int partition01(T[] nums, int l, int h) { //切分
        int i = l;
        int j = h + 1;
        T v = nums[l];
        while (true) {
            while(less(nums[++i], v) && i < j);
            while(less(v, nums[--j]) && i < j);
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, i); //把基准数放入正确位置
        return i;
    }
}
