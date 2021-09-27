package wei.thread;

import java.util.concurrent.FutureTask;

/**
 * @ClassName CreatOfThread
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class CreatOfThread {
    /**
     * @description:继承Thred类并重写run方法
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void creatOfThread01() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(getName()+i);
                }
            }
        }.start();
    }
    public void creatOfThread02() {
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+i);
            }
        }).start();
    }
    public void creatOfThread03() {
        new Thread(new FutureTask(()->{
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
                sum += i;
            }
            return sum;
        })).start();
    }

    public static void main(String[] args) {
        CreatOfThread creatOfThread = new CreatOfThread();
        //new CreatOfThread().creatOfThread01();
        //creatOfThread.creatOfThread02();
        //creatOfThread.creatOfThread03();
        for (int i = 20; i < 30; i++) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
