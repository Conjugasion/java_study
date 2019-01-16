package reflect;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther Lucas
 * @date 2019/1/16 9:47
 */
public class acquireMethod {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Class.forName("reflect.person");
        Object obj = c.newInstance();

//        Method[] methods = c.getMethods();
//        for (Method m : methods) {
//            System.out.println(m);
//        }
//
//        Method eat = c.getMethod("eat", null);
//        int i = (int) eat.invoke(obj,null);
//        System.out.println(i);

        Method[] methods = c.getDeclaredMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
    }

}
