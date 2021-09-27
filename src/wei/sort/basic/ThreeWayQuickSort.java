package wei.sort.basic;

/**
 * @ClassName ThreeWayQuickSort
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {
  protected void sort(T[] nums, int l, int h){
      if (h <= 1) {
          return;
      }
      int It = 1, i = l +1, gt = h;
      T v = nums[l];
      while (i <= gt){
          int cmp = nums[i].compareTo(v);
          if (cmp < 0) {
              swap(nums, It++, i++);

          } else if (cmp >0) {
              swap(nums, i, gt--);
          } else {
              i++;
          }
      }
      sort(nums, l, It - 1);
      sort(nums, It + 1,h);
  }
}
