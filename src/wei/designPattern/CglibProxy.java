package wei.designPattern;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CglibProxy
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;
    //传入被代理的对象
    public CglibProxy(Object target) {
        this.target = target;
    }
    //返回一个代理对象
    public Object getProxyInstance() {
        //创建一个工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类对象，即代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理对象开始");
        Object returnVal = method.invoke(target, objects);
        System.out.println("Cglib动态代理结束");
        return returnVal;
    }
}
