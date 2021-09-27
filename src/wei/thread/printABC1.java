package wei.thread;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName printABC
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class printABC1 {
    public static final Object Lock = new Object();
    public static Lock lock1 = new ReentrantLock();
    public static Condition c1 = lock1.newCondition();
    public static Condition c2 = lock1.newCondition();
    public static Condition c3 = lock1.newCondition();
    public static Semaphore s1 = new Semaphore(1);
    public static Semaphore s2 = new Semaphore(0);
    public static Semaphore s3 = new Semaphore(0);
    public static int num;
    /**
     * @description:使用wait和notify打印AB，一个先等待，一个先唤醒
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void printAb() {
        Object o = new Object();
        Object o1 = new Object();
        new Thread(()->{
            synchronized (o) {
                int i = 0;
                while (i < 10) {
                    i++;
                    System.out.println("线程1。。。。。。A");
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    o.notify();
                }
            }

        }).start();
        new Thread(()->{
            synchronized (o) {
                int i = 0;
                while (i < 10) {
                    System.out.println("线程2。。。。。。B");
                    i++;
                    o.notify();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }
    /**
     * @description:交替打印ABC
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void printABC(int o) {
        for (int i = 0; i < 10; i++) {
            synchronized (Lock) {
                while (num % 3 != o) {
                    try {
                        Lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                Lock.notifyAll();//唤醒所有
            }
        }

    }
    /**
     * @description:N个线程交替打印数字
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void printAB(int o) {
        for (int i = 0; i < 10; i++) {
            synchronized (Lock) {
                while (num % 6 != o) { //当符合条件才能跳出while循环
                    try {
                        Lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                num++;//不会有多个线程同时进行num++
                System.out.println(Thread.currentThread().getName() + num);
                Lock.notifyAll();
            }
        }

    }
    /**
     * @description:交替打印奇偶数
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void printOddEven() {
        synchronized(Lock) {
            while (num < 10) {
                System.out.print(Thread.currentThread().getName()+":");
                System.out.println(++num);
                Lock.notify();
                try {
                    Lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Lock.notify();//防止while结束后，仍有子线程阻塞，主线程无法退出
        }
    }
    /**
     * @description:通过join方法，在线程A中调用线程B的join方法，线程B执行完后才继续执行线程A
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void joinAbc(Thread beforeThread ) {
        Thread before = beforeThread;
        if (beforeThread != null) {
            try {
                beforeThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName());
    }
    /**
     * @description:使用lock锁来实现输出ABC
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void lockAbc(int obj) {
        for (int i = 0; i < 10;) {
            lock1.lock();
            if (num % 3 == obj) {
                num++;
                i++;
                System.out.println(Thread.currentThread().getName());
            }
            lock1.unlock();
        }
    }
    /**
     * @description:使用Lock+Condition实现对线程的精准唤醒，减少对同步锁的无意义竞争，浪费资源
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void lockConditionAbc(int obj, Condition currentThread, Condition nextThread) {
        for (int i = 0; i < 10;) {
            lock1.lock();
            try {
                while (num % 3 != obj) {
                    currentThread.await();//阻塞当前线程
                }
                num++;
                i++;
                System.out.println(Thread.currentThread().getName());
                nextThread.signal();//唤醒下一个线程，而不是唤醒所有线程
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock1.unlock();
            }
        }
    }

    /**
     * @description:
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void semaphore(Semaphore currentThread,Semaphore nextThread){
        for (int i = 0; i < 10;i++) {
            try {
                currentThread.acquire();
                System.out.println(Thread.currentThread().getName());
                nextThread.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {


    }


}
