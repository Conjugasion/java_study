package staticInvoke;

/**
 * @auther Lucas
 * @date 2018/12/28 16:26
 * 加载不是初始化
 */
public class test {
    public static void main(String[] args) {
        // father s = new son();
        // 静态成员变量  看父类
        // System.out.println(s.i);
        // 非静态成员变量  看父类
        // System.out.println(s.j);
        // 父类中没有的成员变量 报错
        // System.out.println(s.k);
        // 父类中没有的静态/非静态方法，报错
        // s.swim();
        // 非静态方法 看子类
        // s.run();
        // 静态方法 看父类
        // s.eat();


        // 调用子类和父类公有的静态变量，父类静态代码块会运行(加载)
        // System.out.println(son.i);
        // 调用了子类特有的静态变量，父类静态代码块会运行(加载)
        // System.out.println(son.m);
        // 调用子类和父类公有的静态方法，父类静态代码块会运行(加载)
        // son.eat();
        // 调用了子类特有的静态方法，父类静态代码块会运行(加载)
         // son.basket();
        // 子类调用父类中特有的静态变量，父类静态代码块会运行(加载)，子类不会被加载
        // System.out.println(son.l);
        // 子类调用父类中特有的静态方法，父类静态代码块会运行(加载)，子类不会被加载
        // son.tennis();

         // 父类/子类的final变量直接放入自身常量池，父类调用或者子类调用均不会引起初始化
         // System.out.println(father.n);
         // System.out.println(son.n);
         // System.out.println(son.o);

         // final方法也会引起初始化
         // son.kill();

        // 数组不会引起初始化
        // father[] farray = new father[10];
        // son[] sarray = new son[10];

    }
}
