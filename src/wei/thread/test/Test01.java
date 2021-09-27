package wei.thread.test;

import wei.thread.printABC1;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Test01 extends printABC1{
    public void testJoin() {
        printABC1 test = new printABC1();
        Thread t0 = new Thread(()->test.joinAbc(null), "A");
        Thread t1 = new Thread(()->test.joinAbc(t0), "B");
        Thread t2 = new Thread(()->test.joinAbc(t1), "C");
        t0.start();
        t1.start();
        t2.start();

    }
    public void lockCondition() {
        new Thread(()->lockConditionAbc(0, c1, c2), "A").start();
        new Thread(()->lockConditionAbc(1, c2, c3), "B").start();
        new Thread(()->lockConditionAbc(2, c3, c1), "C").start();
    }
    public void semaphore() {
        new Thread(()->semaphore(s1, s2), "A").start();
        new Thread(()->semaphore(s2, s3), "B").start();
        new Thread(()->semaphore(s3, s1), "C").start();
    }
}
