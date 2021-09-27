package wei.reflect;

import test.dao.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName GetClass
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class GetClass {
    /**
     * @description:通过forName方法获取Class对象，
     * 装入类，并做类的静态初始化，返回Class的对象。
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void getClass01() {
        Class Class1 = null;
        try {
            Class1 = Class.forName("test.dao.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Class1);
    }
    /**
     * @description:JVM将使用类装载器，将类装入内存(前提是:类还没有装入内存)，不做类的初始化工作，返回Class的对象。
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public Class getClass02() {
        Class<User> userClass = User.class;
            System.out.println(userClass);
            return userClass;
    }
    /**
     * @description:对类进行静态初始化、非静态初始化；
     * 返回引用运行时真正所指的对象(子对象的引用会赋给父对象的引用变量中)所属的类的Class的对象。
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void getClass03() {
        User user = new User();
        Class<? extends User> aClass = user.getClass();
        System.out.println(aClass);

    }
    /**
     * @description:获取有参构造器进行创建对象
     * @author: 卫依伦
     * @date: 2021/9/29
     */
    public void creatInstance() {
        Class clazz= getClass02();
        try {
            Constructor constructor = clazz.getConstructor(int.class, int.class, int.class);//参数是构造器参数类型
            System.out.println(constructor);
            Object o = constructor.newInstance(10, 20, 30);
            System.out.println(o.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    /**
     * @description:通过反射调用方法
     * @author: 卫依伦
     * @date: 2021/9/30
     */
    public void getMethod() {
        User user = new User();
        try {
            Method commonMethod = user.getClass().getMethod("commonMethod", String.class);//方法名字，参数类型
            commonMethod.invoke(user, "通过反射执行方法");//参数：对象，方法的参数
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * @description:通过反射获取对象的属性
     * @author: 卫依伦
     * @date: 2021/9/30
     */
    public void getField(Object obj) {
        String value = "";
        Class<?> claszz = obj.getClass();
        Field[] fileds = claszz.getDeclaredFields();
        for (Field filed : fileds) {
            filed.setAccessible(true);
            Object o = null;
            try {
                o = filed.get(obj);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            value += filed.getName() + ":" + o + ",";
        }
        int i = value.lastIndexOf(",");
        String result = value.substring(0, i);
        System.out.println(result);

    }
    public static void main(String[] args) {
        GetClass getClass = new GetClass();
         User user = new User(6,7 , 8);
        //getClass.getClass03();
        //getClass.creatInstance();
        //getClass.getMethod();
        getClass.getField(user);
    }
}
