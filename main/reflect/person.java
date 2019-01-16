package reflect;

/**
 * @auther Lucas
 * @date 2019/1/15 21:16
 */
public class person {
    String name;
    Integer age;
    String job;

    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("构造块");
    }
    public person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public person() {
    }

    private person(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public void run(){
        System.out.println("跑步");
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
