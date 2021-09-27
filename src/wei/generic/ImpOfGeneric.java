package wei.generic;

/**
 * @ClassName ImpOfGeneric
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class ImpOfGeneric implements GenericInterface<String> {
    @Override
    public String next() {
        String s = "abc";
        System.out.println("这是泛型接口的一个实现类");
        return s;
    }
}
