package collectionDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther Lucas
 * @date 2019/1/4 14:44
 */
public class arrayListDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>(){{
            add("asd1");
            add("asd2");
            add("asd2");
        }};

        list1.remove("asd2");
        System.out.println(list1);

        System.out.println(list1.contains("asd1"));
    }
}
