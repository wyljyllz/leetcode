package test.dao;

/**
 * @ClassName Person
 * @Description TODO
 * @Author wyl
 * @Data
 */
public class Person {
    private int age;

    public String hobby;
    public Person() {

    }
    public Person(int age, String hobby) {
        this.age = age;
        this.hobby = hobby;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
