package wei.generic;

/**
 * @ClassName GenericClass
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class GenericClass<T> {
    private T key;
    public GenericClass() {

    }
    public GenericClass(T key) {
        this.key = key;
    }
    public <J> void genericMethod(J tar) {
        System.out.println(tar);
    }
    public T getKey() {
        return key;
    }
}
