package staticInvoke;

/**
 * @auther Lucas
 * @date 2018/12/28 16:26
 */
public class test {
    public static void main(String[] args) {
        father s = new son();
        // 静态成员变量  看父类
        System.out.println(s.i);
        // 非静态成员变量  看父类
        System.out.println(s.j);
        // 父类中没有 报错
        // System.out.println(s.k);
        // 非静态方法 看子类
        s.run();
        // 静态方法 看父类
        s.eat();
    }
}
