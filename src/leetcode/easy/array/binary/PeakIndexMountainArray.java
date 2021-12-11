package leetcode.easy.array.binary;

/**
 * @ClassName PeakIndexMountainArray
 * @Description 山峰数组的顶部
 * @Author wyl
 * @Data
 */
public class PeakIndexMountainArray {
    /**
     * @description:枚举
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int ans = -1;
        for (int i = 1; i < n - 1; ++i) {
            if (arr[i] > arr[i + 1]) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * @description:二分
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    public int peakIndexInMountainArray01(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid + 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
    /**
     * @description:
     * @author: 卫依伦
     * @date: 2021/12/11
     */
    public int peakIndexInMountainArray02(int[] arr) {
        int n = arr.length;
        int left = 1, right = n - 2, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
