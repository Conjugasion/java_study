package superDemo;

/**
 * @auther Lucas
 * @date 2018/12/28 14:41
 */
public class person {
    int age;
    {
        System.out.println("person no static");
    }
    static {
        System.out.println("person static");
    }
    public person(String name){
        System.out.println("person name");
}

    public person(int age){
        this.age = age;
        System.out.println("person age");
    }

}
