package mapDemo;

import java.util.*;

/**
 * @auther Lucas
 * @date 2019/1/4 20:41
 * 有序
 */
public class linkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<String,String> linkMap = new LinkedHashMap<>();
        linkMap.put("asd", "a");
        linkMap.put("qwe", "b");
        linkMap.put("zxc", "c");
        linkMap.put("rty", "d");
        linkMap.put("fgh", "e");
        linkMap.put("vbn", "f");
        linkMap.put(null, null);


        Iterator<Map.Entry<String, String>> iterator = linkMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println("key: " + next.getKey() + ", value: " + next.getValue());
        }

        System.out.println("************************");
        Map<String,String> map = new HashMap<>();
        map.put("asd", "a");
        map.put("qwe", "b");
        map.put("zxc", "c");
        map.put("rty", "d");
        map.put("fgh", "e");
        map.put("vbn", "f");
        map.put(null, null);

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String, String> next = it.next();
            System.out.println("key: " + next.getKey() + ", value: " + next.getValue());
        }

        Map<String,String> table = new Hashtable<>();
        //table.put("1", null);
        //table.put(null, "2");

        Map<String, String> tree = new TreeMap<>();
        tree.put("1", null);
        //tree.put(null, "2");
    }

}
