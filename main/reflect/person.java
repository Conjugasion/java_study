package reflect;

/**
 * @auther Lucas
 * @date 2019/1/15 21:16
 */
public class person extends animal{
    String name;
    Integer age;
    String job;
    private int a = 100;
    public int b = 200;
    int c = 300;

    static {
        System.out.println("静态代码块");
    }
    {
        System.out.println("构造块");
    }
    public person(String name, Integer age) {
        super(1);
        this.name = name;
        this.age = age;
    }

    public person(Integer age, String name) {
        super(0);
        this.name = name;
        this.age = age;
    }

    public person() {
        super(2);
    }

    private person(String name, String job) {
        super(3);
        this.name = name;
        this.job = job;
    }

    public void run(){
        System.out.println("跑步");
    }

    private void watch(){
        System.out.println("看电视");
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
