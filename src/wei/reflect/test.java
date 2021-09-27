package wei.reflect;

import test.dao.Eat;
import test.service.eatIml;
import test.service.sleep;
import wei.designPattern.CglibProxy;

/**
 * @ClassName test
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class test {
    public void testJdk() {
        eatIml eatIml = new eatIml();
        JdkProxy jdkProxy = new JdkProxy(eatIml);
        Eat proxyInstance = (Eat) jdkProxy.getProxyInstance();
        proxyInstance.eat();
    }
    public void testCglib() {
        sleep proxyInstance =(sleep) new CglibProxy(new sleep()).getProxyInstance();
        proxyInstance.sleep();
    }
    public static void main(String[] args) {
        test test = new test();



        //test.testJdk();
        //test.testCglib();

    }
}
