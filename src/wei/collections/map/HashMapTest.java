package wei.collections.map;

import java.util.*;

/**
 * @ClassName HashMapTest
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class HashMapTest {
    public static void main (String[] args) {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(1,"aaa");
        hashMap.put(1,"aa");
        hashMap.put(3,"aaa");
        Set<Integer> objects = hashMap.keySet();//获得key，存入set
        Iterator<Integer> it = objects.iterator();
        while (it.hasNext()) {
            Integer next = (Integer) it.next();
            Object value = hashMap.get(next);
            System.out.println(next + "---->" + value);
        }
        Set<Map.Entry<Integer, Object>> entries = hashMap.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        Collection<Object> values = hashMap.values();
        for (Object val : values) {
            System.out.println(val);
        }
    }
}
