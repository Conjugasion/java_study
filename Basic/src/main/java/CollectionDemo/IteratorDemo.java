package CollectionDemo;

import StaticInvoke.father;
import StaticInvoke.son;

import java.util.*;

/**
 * @auther Lucas
 * @date 2019/1/4 9:19
 * 迭代器
 */
public class IteratorDemo {

    public static void main(String[] args) {
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

    public Class<?> clazz(){
        // return String.class;
        return Integer.class;
    }

}
