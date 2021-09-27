package wei.sort.basic;

/**
 * @ClassName 约定
 * @Description TODO
 * @Author wyl
 * @Data
 */
public abstract class sort<T extends Comparable<T>> {
    public abstract void sort(T[] nums);
    protected boolean less(T v,T w){
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a,int i,int j){
        T t = a[i];
        a[i] =a[j];
        a[j] = t;
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
}
