package collectionDemo;

import java.util.*;

/**
 * @auther Lucas
 * @date 2019/1/4 15:12
 * 无序，非重复
 * 存储，取出都比较快
 * hashCode和equals只要有一个不同，hashSet就认为是不同元素，会存储
 */
public class setDemo {
    public static void main(String[] args) {
        Set<String> hashset1 = new HashSet<>();
        hashset1.add(null);
        hashset1.add("asd1");
        hashset1.add("asd2");
        hashset1.add("asd3");

//        Iterator it = hashset1.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }

        String str1 = "asd4";
        String str2 = new String("asd4");
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        hashset1.add("asd4");
        hashset1.add(new String("asd4"));
        System.out.println(hashset1);

        person lucas1 = new person("lucas",24);
        person lucas2 = new person("lucas",25);
        System.out.println("lucas1 =? lucas2: "+ lucas1.equals(lucas2));

        System.out.println(lucas1.hashCode());
        System.out.println(lucas2.hashCode());

        Set<person> hashset2 = new HashSet<person>(){{
            add(lucas1);
            add(lucas2);
        }};
        System.out.println(hashset2);
    }
}
