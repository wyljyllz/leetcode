package exercise.recurrence;

/**
 * @ClassName fibonacii
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class fibonacii {
    public static int seek(int n) {
        if(n == 1)
            return 0;
        if(n == 2)
            return 1;
        return seek(n - 1) + seek(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(seek(6));
    }
}
