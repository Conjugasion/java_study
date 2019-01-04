package collectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @auther Lucas
 * @date 2019/1/4 13:42
 * 迭代器的并发修改异常
 * 遍历的过程中，修改了集合的长度
 * 要用迭代器的方法删除元素
 */
public class IteratorModify {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("asd1");
        list1.add("asd2");
        list1.add("asd3");
        list1.add("asd4");

        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals("asd3")) {
                // 使用迭代器的删除方法
                it.remove();
                // list1.add("asd5");
            }
            System.out.println(s);
        }
        System.out.println(list1);


        List<String> list2 = new ArrayList<>();
        list2.add("asd1");
        list2.add("asd2");
        list2.add("asd3");
        list2.add("asd4");
        ListIterator<String> listIt = list2.listIterator();
        while (listIt.hasNext()) {
            String s = listIt.next();
            if (s.equals("asd3")) {
                // 使用迭代器的删除方法
                listIt.remove();
                listIt.add("asd5");
            }
            System.out.println(s);
        }
        System.out.println(list2);
    }
}
