package wei.reflect;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkProxy
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class JdkProxy {
    private Object target = new Object();
    public JdkProxy(Object target) {
        this.target = target;
    }
    //生成一个代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK动态代理开始");
                        Object returnVal = method.invoke(target, args);
                        System.out.println("JDK动态代理结束");
                        return returnVal;
                    }
                });
    }
}
