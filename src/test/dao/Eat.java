package test.dao;

/**
 * @ClassName Eat
 * @Description TODO
 * @Author wyl
 * @Data
 */
public interface Eat {
   default void eat() {
      System.out.println("11");
   }
}
