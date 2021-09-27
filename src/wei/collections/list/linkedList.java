package wei.collections.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName linkedList
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class linkedList {
    public static void main(String[] args) {
        LinkedList<Object> link = new LinkedList<>();
        link.add("赵");
        link.add("钱");
        link.add("孙");
        link.add("李");
        //List<Object> objects = link.subList(0, 3);
        link.clear();
        //link.add(1,"卫");
        Iterator<Object> it = link.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
