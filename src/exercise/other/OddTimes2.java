package exercise.other;

/**
 * @ClassName OddTimes2
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class OddTimes2 {
    /**
     * @description:一个数组，只有两个数的个数为奇数个，其余都为偶数个，求这两个数的值
     * 异或操作，又叫无进位相加，一个数和0异或是它本身，两个相同的异或值为0，
     * 异或操作符合交换率和结合律
     * @author: 卫依伦
     * @date: 2021/10/2
     */
    public static void printOddTimes2(int[] array) {
        int eor = 0;
        for (int arr : array) {//所有个数为偶数的值异或结果为0，剩下了a^b
            eor ^= arr;
        }
        //System.out.println(eor);
        int rightOne = eor & (~eor + 1);//提取处最右边的1
        int o = 0;
        for (int arr : array) { //找到其中一个的值
            if ((arr & rightOne) == 0) {
                o ^= arr;
            }
        }
        System.out.println("这两个值分别是" + o + "和" + (eor ^ o));
    }
    public static void main(String[] args) {
        int[] array = {1,1,2,2,77,8,8,78,99,78};
        printOddTimes2(array);
    }
}
