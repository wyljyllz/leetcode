package wei.collections.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName linkedList
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class linkedList {
    public static void testDuqeu(){
        LinkedList<Integer> integers = new LinkedList<>();
        integers.push(1);//头插法
        integers.push(2);
        integers.push(3);
        integers.push(4);
        while(!integers.isEmpty()) {
            System.out.print(integers.pop() + " ");
        }
        System.out.println("");
        LinkedList<Integer> integers1 = new LinkedList<>();
        integers1.add(1);//尾插法
        integers1.add(2);
        integers1.add(3);
        integers1.add(4);
        while (integers1.peek() != null) {
            System.out.print(integers1.pop() + " ");
        }
        System.out.println("");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }

    }
    public static void main(String[] args) {
//        LinkedList<Object> link = new LinkedList<>();
//        link.add("赵");
//        link.add("钱");
//        link.add("孙");
//        link.add("李");
//        //List<Object> objects = link.subList(0, 3);
//        link.clear();
//        //link.add(1,"卫");
//        Iterator<Object> it = link.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
        testDuqeu();
    }
}
