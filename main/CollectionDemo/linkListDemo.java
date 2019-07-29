package CollectionDemo;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @auther Lucas
 * @date 2019/1/4 14:38
 */
public class linkListDemo {
    public static void main(String[] args) {
        LinkedList<String> link1 = new LinkedList<>();
            link1.add("asd1");

        String[] strs = {"asd2","asd3","asd4"};
        link1.addAll(Arrays.asList(strs));
        System.out.println(link1);

        System.out.println(link1.get(0));
        System.out.println(link1.pop());
        System.out.println(link1);

    }
}
