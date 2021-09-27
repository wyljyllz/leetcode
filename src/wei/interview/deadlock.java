package wei.interview;

import java.util.ArrayList;

/**
 * @ClassName deadlock
 * @Description 写一个死锁程序
 * @Author wyl
 * @Data
 */
public class deadlock {
    /**
     * @description:synchronized造成的死锁
     * @author: 卫依伦
     * @date: 2021/9/26
     */

    public static void deadlock1() {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(()->{
            synchronized (lock1){
                System.out.println("线程1获取lock1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("线程1获取Lock2");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (lock2){
                System.out.println("线程2获取lock2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("线程2获取lock1");
                }
            }

        }).start();

    }
/**
 * @description:wait和notify解决死锁
 * @author: 卫依伦
 * @date: 2021/9/26
 */
    public static void deadlock2(){
        final deadlock d1 = new deadlock();
        final deadlock d2 = new deadlock();
        new Thread(()->{
            synchronized (d1){
                System.out.println(Thread.currentThread().getName()+"线程获取d1锁");
                try {

                    Thread.sleep(1000);
                   // d1.notify();
                    synchronized(d2){
                        System.out.println(Thread.currentThread().getName()+"线程获取d2锁");
                        d2.notify();
                        Thread.sleep(2000);//执行完才释放所有锁
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        new Thread(()->{
            synchronized(d2){
                System.out.println(Thread.currentThread().getName()+"线程获得d2锁");
                try {
                    d2.wait();
                   // Thread.sleep(1000);
                    synchronized(d1){
                        System.out.println(Thread.currentThread().getName()+"线程获得d1锁");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
                 }).start();

    }
/**
 * @description:
 * @author: 卫依伦
 * @date: 2021/9/26
 */
    public static void deadlock3(){
        Object o1 = new Object();
        Object o2 = new Object();
       // lock(o2,o1);//线程是在后面开启的，等待执行完毕，所以不会造成死锁
        new Thread(()->{
            lock(o1,o2);
                 }).start();
        lock(o2,o1);

    }
    public static void lock(Object o1,Object o2){
        synchronized (o1){
            System.out.println(Thread.currentThread().getName()+"线程获取o1锁");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+"线程获取o2锁");
            }
        }
    }
    public static void main(String[] args) {
        deadlock.deadlock2();
    }

}
