package test.dao;

/**
 * @ClassName User
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class User {
    private static int age = 5;
    public int height;
    public int weight;
    public User() {
        System.out.println("无参构造器执行");
    }
    public User(int age, int height, int weight) {
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
    static {
        System.out.println("静态代码块执行");
        System.out.println("age==" + age);
    }
    public static void staticMethod() {
        System.out.println("静态方法执行");
    }
    public void commonMethod(String s) {
        System.out.print("这是一个普通方法---");
        System.out.println(s);
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "height=" + height +
                ", weight=" + weight +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
