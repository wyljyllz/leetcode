package wei.sort.basic;

import java.util.*;

/**
 * @ClassName Bucket
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Bucket extends sort {
    public static int[] bucketSort(int[] array) {
        int max = array[0];
        int min = array[0];
        int len = array.length;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, array[i]);
            min = Math.min(min, array[i]);
            }
        int d = max - min;
        //初始化桶
        int bucketNum = (max - min) / len + 1;
        System.out.println(bucketNum);
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        System.out.println("初始化桶完成");
        //将元素放入桶并排序
        for (int data : array) {
            int num = (int) (data - min) / len;
            System.out.println(num);
            insertSort(bucketList.get(num), data);
            System.out.println("1111");

        }
        System.out.println("2222");
        //输出全部元素
        int[] sortedArray = new int[len];
        int index = 0;
        for (LinkedList<Integer> list : bucketList) {
            for (int element : list) {
                sortedArray[index++] = element;
            }
        }
        return sortedArray;
    }

    public static void  insertSort(List bucket, int data) {
        ListIterator<Integer> it = bucket.listIterator();
        boolean insertFlag = true;
        while (it.hasNext()) {
            if (data <= it.next()) {
                it.previous();
                it.add(data);
                insertFlag = false;
                break;//一旦小于就跳出while
            }
        }
        if (insertFlag) {
            bucket.add(data);
        }
    }
    public static void main(String[] args) {
        int[] array= gennerateArray(10, 20);
        System.out.println(Arrays.toString(array));
        int[] ints = bucketSort(array);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void sort(Comparable[] nums) {

    }
}
