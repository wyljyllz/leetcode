package test;

import test.dao.SeasonEnum;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;

/**
 * @ClassName test
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class test {
    /**
     * @description:add操作进行插入
     * @author: 卫依伦
     * @date: 2021/9/28
     */
    public static void listAdd() {
        ArrayList<Object> objects = new ArrayList<>(10);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        objects.addAll(integers);
        objects.add(2,9);
        for (Object emelent :objects) {
            System.out.println(emelent);
        }
    }
    public static int divide(int x,int y) throws Exception {
        if(y<0)
        {

                throw new Exception("被除数是负数");

        }
        int result = x/y;
        return result;
    }
    public static void test() throws Exception {
            divide(5,-1);
    }
    public static void stringTest(String s1) {
        s1 = "11"; //进行了修改
    }
    public static String stringTest1(String s1) {
        s1 = "aaa";
        return s1;
    }
    public static void hashMapTest(HashMap s) {
        HashMap s1 = s;
        s1.remove("1");

    }
    public static void hashMapTest() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1","5");
        objectObjectHashMap.put("2","5");
        objectObjectHashMap.put("3","5");
        hashMapTest(objectObjectHashMap);
        Set<Map.Entry<Object, Object>> entries = objectObjectHashMap.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
    public static void main(String[] args)  {
//        String s1 = "abc";
//        String s = stringTest1(s1);
//        System.out.println(s);


    }

}
