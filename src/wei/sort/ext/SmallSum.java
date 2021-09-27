package wei.sort.ext;

/**
 * @ClassName SmallSum
 * 在一个数组中， 每一个数左边比当前数小的数累加起来， 叫做这个数组的小和
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class SmallSum {
    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        int m = L + ((R - L) >> 1);
        return mergeSort(arr, L, m) +
                mergeSort(arr, m + 1, R) +
                merge(arr, L, m, R);
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int count = 0;
        int index1 = l;
        int index2 = m + 1;
        int i = 0;
        while (index1 <= m && index2 <= r) {
            count += (arr[index1] < arr[index2]) ? (arr[index1]) * (r - index2 + 1) : 0;
            help[i++] = (arr[index1] < arr[index2]) ? arr[index1++] : arr[index2++];
            //等于的时候先放右边，不能先放左边，不然会漏掉例如【1，1，1，2，3】【1，1，4，5】，先左边会漏掉6个1（4和5）
        }
        while (index1 <= m) {
            help[i++] = arr[index1++];

            while (index2 <= r) {
                help[i++] = arr[index2++];
            }
            for (int j = 0; j < help.length; j++) {
                arr[l + j] = help[j];
            }
            return count;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        System.out.println(smallSum(arr));
    }
}
