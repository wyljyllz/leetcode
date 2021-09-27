package wei.sort.basic;

/**
 * @ClassName Radix
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Radix {
    public static void radixSort(int[] array) {
        int n = 1;
        int k = 0;
        int len = array.length;

        int max = array[0];
        for (int i = 0;i < len; i++) {
            if (max < array[i])
                max = array[i];
        }

        int times = 0;
        while (max != 0) {
            times++;
            max /= 10;
        }

        int[] [] bucket = new int[10][len];//10代表10个桶，len元素个数
        int[] order = new int[10];//保存每个桶里元素个数
        while (n <= times) {
            for (int num : array) {  //将数组中的元素存放到桶中
                int digit = num / (int) Math.pow(10, n - 1) % 10;//pow(x,y)x的y次方
                bucket[digit][order[digit]] = num;
                order[digit]++;
            }

            for (int i = 0; i < 10; i++) { //回收桶中元素，赋值给数组
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        array[k] = bucket[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n++;
            k = 0;
        }

    }
}
