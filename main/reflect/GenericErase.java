package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @auther Lucas
 * @date 2019/1/16 10:07
 */
public class GenericErase {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");

        // 反射取出List中的add()方法
        Class c = list.getClass();
        Method myAdd = c.getMethod("add", Object.class);
        System.out.println(myAdd);
        myAdd.invoke(list,100);
        myAdd.invoke(list,200);
        myAdd.invoke(list,300);
        System.out.println(list);

        for (Object obj : list) {
            System.out.println(obj);
        }

        Iterator it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
