package classLoad;

/**
 * @auther Lucas
 * @date 2019/1/24 22:24
 */
public class person {
    public static final int a;
    public final int b;
    String name;
    int age;

    static {
        a = 100;
    }

    public person() {
        b = 200;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
