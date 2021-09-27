package wei.generic;

import test.dao.Person;
import test.dao.Student;
import test.dao.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Test01 {
    /**
     * @description:测试泛型类
     * @author: 卫依伦
     * @date: 2021/9/30
     */
    public static void genericClassTest() {
        GenericClass<Integer> integerGenericClass = new GenericClass<Integer>(40);
        Integer key = integerGenericClass.getKey();
        System.out.println(key);
        GenericClass<String> stringGenericClass = new GenericClass<>("string");
        System.out.println(stringGenericClass.getKey());
    }
    /**
     * @description:测试泛型接口
     * @author: 卫依伦
     * @date: 2021/9/30
     */
    public static void genericInterfaceTest() {
        ImpOfGeneric impOfGeneric = new ImpOfGeneric();
        impOfGeneric.next();
    }
    /**
     * @description:测试泛型方法
     * @author: 卫依伦
     * @date: 2021/9/30
     */
    public static void genericMethod() {
        GenericClass<String> stringGenericClass = new GenericClass<>();
        stringGenericClass.genericMethod(40);
        stringGenericClass.genericMethod("sss");
        stringGenericClass.genericMethod(new User(10, 20, 60));

    }
    /**
     * @description:泛型通配符和上下边界
     * @author: 卫依伦
     * @date: 2021/9/30
     */
    public static void wildCardTest() {
        List<? extends Person> list1 = null;
        List<? super Student> list2 = null;
        List<Student> list3 = new ArrayList<>();
        List<Person> list4 = new ArrayList<>();
        List<Object> list5 = new ArrayList<>();
        list3.add(new Student());
        list1 = list3;
        //list1.add(new Person());
        //list1 = list5;
        list2 = list5;
        Person person = list1.get(0);
        //Student student = list1.get(0);
        list2.add(new Student());
        Object object = list2.get(0);

    }
    public static void main (String[] args) {
        //genericClassTest();
        //genericInterfaceTest();
        //genericMethod();
        //wildCardTest();
    }
}
