package ThreadDemo.waitAndNotify;

/**
 * @auther Lucas
 * @date 2019/1/14 18:32
 */
public class person {
    public static int a = 100;

    public static void main(String[] args) {
        System.out.println(new person().a);
        new person().a = 200;
        System.out.println(new person().a);
        person.a = 300;
        System.out.println(new person().a);
    }
}
