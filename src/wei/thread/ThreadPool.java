package wei.thread;

import java.util.Date;
import java.util.concurrent.*;

/**
 * @ClassName ThreadPool
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ThreadPool {
    /**
     * @description:使用静态方法newScheduledThreadPool来创建创建一个定长线程池，支持定时及周期性任务执行
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void scheduledThreadPoolTest() {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(3);
        executorService.schedule(() -> {
            System.out.println("5s后输出");
        }, 5, TimeUnit.SECONDS);
        executorService.shutdown();
    }

    /**
     * @description:创建一个单例线程化的线程池，只使用唯一的工作线程执行任务，所有任务顺序执行。
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void singleThreadPoolTest() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            final int index = 1;
            executorService.execute(()->{
                try{
                    System.out.println(Thread.currentThread().getName()  + index);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * @description:创建一个可重用固定个数的线程池，以共享队列的无界队列来存放任务
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void fiexedThreadPoolTest() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                for (int j =0; j < 3; j++) {
                    System.out.println(Thread.currentThread().getName() +"--->" + j);
                }
            });
        }
        executorService.shutdown();
    }

    /**
     * @description:可缓存线程池，查看是否有线程，有就使用，没有进行创建
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void cachedThreadPoolTest() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        executorService.shutdown();
    }
    /**
     * @description:自定义线程池和缓冲队列
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void defineThreadPoolTest() {
        ArrayBlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(3, 6, 50, TimeUnit.MILLISECONDS, blockingQueue);
        executorService.execute(()-> System.out.println(Thread.currentThread().getName() + " 11111"));
        executorService.execute(()->{

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "22222");
        });
        executorService.execute(()-> System.out.println(Thread.currentThread().getName() + "33333"));
        executorService.shutdown();

    }
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        System.out.println(new Date());
        //new ThreadPool().scheduledThreadPoolTest();
        //threadPool.singleThreadPoolTest();
        //threadPool.fiexedThreadPoolTest();
        //threadPool.cachedThreadPoolTest();
        //threadPool.defineThreadPoolTest();
    }
}

