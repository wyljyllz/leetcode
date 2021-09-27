package wei.collections.list;

import java.util.*;

/**
 * @ClassName arrayList
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class arrayList {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>(Arrays.asList(10,11,12,13));
        int[] array = {1,3,5,7};
        new HashMap();
        Iterator<Object> iterator = objects.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" ");
        }
        System.out.println("");
        Collections.shuffle(objects);
        Iterator<Object> iterator1 = objects.iterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next());
            System.out.print(" ");
        }
    }
}
