package wei.sort.basic;

/**
 * @ClassName HeapSort1
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class HeapSort1 {
    static int len;
    public static int[] HeapSort(int[] array) {
        len = array.length;
        if (len < 1)
            return array;
        buildMaxHeap(array);
        while (len > 0) {
            swap(array, 0, --len);
            adjustHeap(array,0);
        }
        return array;
    }

    private static void swap(int[] array, int i, int i1) {
        int s = array[i];
        array[i] = array[i1];
        array[i1] = s;
    }

    private static void adjustHeap(int[] array, int i) {
        int maxIndex = i;
        int k = 2 * i + 1;
        if (k < len && array[k] > array[maxIndex])
            maxIndex = k;
        if (k + 1 < len && array[k + 1] > array[maxIndex]) {
            maxIndex = k + 1;
        }
        if (maxIndex != i) {
            swap(array, maxIndex, i);
            adjustHeap(array, maxIndex);
        }

    }

    private static void buildMaxHeap(int[] array) {
        for (int i = (len / 2); i >= 0; i--) {
            adjustHeap(array, i);
        }
    }
    public static int[]  gennerateArray(int len,int max){
        int[] arr=new int[len];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*max);
        }
        return arr;
    }
    public static boolean adjust(int[] array) {
        boolean flag = true;
        for (int i = 1;i < array.length;i++) {
            if (array[i] < array[i - 1])
                flag = false;
        }
        return flag;
    }
    public static void main(String []args){
        int [] arr = gennerateArray(100,100);
        HeapSort(arr);
        System.out.println(adjust(arr));
    }
}
