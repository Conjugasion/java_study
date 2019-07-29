package Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @auther Lucas
 * @date 2019/1/16 9:07
 */
public class acquirePrivate {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class c = Class.forName("Reflect.person");
        Object obj = c.newInstance();
//        Constructor[] cons = c.getDeclaredConstructors();
//        for (Constructor con : cons) {
//            System.out.println(con);
//        }

//        Constructor con = c.getDeclaredConstructor(String.class,String.class);
//        con.setAccessible(true);
//        Object obj = con.newInstance("lucas", "student");
//        System.out.println(obj);
//        System.out.println(c.getDeclaredField("a"));

        // 获得public成员变量 包括父类的
//        Field[] fields = c.getFields();
//        for (Field field : fields) {
//            System.out.println(field);
//        }

        // 获得所有成员变量 不包括父类的
//        Field[] fs = c.getDeclaredFields();
//        for (Field field : fs) {
//            System.out.println(field);
//        }

        // 获取指定成员变量,包括父类的
        Field f = c.getField("d");
        System.out.println(f.get(obj));
        f.set(obj, 2000);
        System.out.println(((person)obj).d);


    }
}
