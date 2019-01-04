package collectionDemo;

import org.junit.Test;
import staticInvoke.father;
import staticInvoke.son;

import java.util.*;

/**
 * @auther Lucas
 * @date 2019/1/4 9:19
 * 迭代器
 */
public class IteratorDemo {

    @Test
    public void ArrayListDemo(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        // arrayList.toArray(new String[10]);

        Iterator<String> it = arrayList.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }

    }

    public <E extends father> E returnE(E e){
        return e;
    }

    @Test
    public void test(){
        father e = returnE(new son());
        System.out.println(e);
    }


    public Class<?> clazz(){
        // return String.class;
        return Integer.class;
    }

}
