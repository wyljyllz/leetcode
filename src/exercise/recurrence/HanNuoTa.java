package exercise.recurrence;

import java.util.Scanner;

    /**
     * @ClassName HanNuoTa
     * @Description TODO
     * @Author wyl
     * @Data
     */
    public class HanNuoTa {
        public static int times = 0;
        public static void hanno(int n, char A, char B, char C) {
            if (n == 1) {
                move(n, A, C);
            } else {
                hanno(n - 1, A, C, B);
                move(n, A, C);
                hanno(n - 1, B, A, C);
            }

        }
        private static void move(int n, char a, char c) {
            System.out.println("第"+(++times)+"次移动，盘子"+n+""+a+"----->"+c);
        }

        public static void main(String[] args) {
            char A ='A';
            char B ='B';
            char C ='C';
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入盘子数");
            int n = scanner.nextInt();
            hanno(n, A, B, C);
            scanner.close();

        }

    }

