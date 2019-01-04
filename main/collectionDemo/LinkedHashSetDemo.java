package collectionDemo;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @auther Lucas
 * @date 2019/1/4 16:21
 * 有序，无重复
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<String> linkedSet1 = new LinkedHashSet<>();
        linkedSet1.add("asd1");
        linkedSet1.add("asd2");
        linkedSet1.add("asd3");
        linkedSet1.add("asd4");
        linkedSet1.add("asd5");

        System.out.println(linkedSet1);
    }
}
