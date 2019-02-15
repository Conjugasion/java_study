package reflect;


import java.lang.reflect.Constructor;

/**
 * @auther Lucas
 * @date 2019/1/15 19:13
 */
public class ClassLoadDemo {
    public static void main(String[] args) throws Exception {
        Class c = Class.forName("reflect.person");
        Class c1 = person.class;
        Class c2 = new person().getClass();

        // 仅能获得公共权限public的构造器
        Constructor[] constructors = c.getConstructors();
        for (Constructor con : constructors) {
            System.out.println(con);
        }

        // 获取指定的构造方法
//        Constructor constructor1 = c.getConstructor(String.class, Integer.class);
//        System.out.println(constructor1);
//        Object obj = constructor1.newInstance("Lucas", 24);
//        System.out.println(obj.getClass());
//        ((reflect.person)obj).run();

    }
}
