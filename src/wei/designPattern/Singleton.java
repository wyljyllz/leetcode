package wei.designPattern;

/**
 * @ClassName Singleton模式
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {

    }
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance =  new Singleton();
                }
            }
        }
        return instance;
    }
}

