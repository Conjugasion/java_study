package mapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @auther Lucas
 * @date 2019/1/4 16:42
 * HashMap无序,null可以当key/value
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<String,String> map1 = new HashMap<>();
        map1.put(null,null);
        map1.put("1",null);
        // 返回值是被覆盖的value
        String covered = map1.put(null,"asd1");
        System.out.println(covered);
        System.out.println(map1.get(null));

        System.out.println("*************");
        HashMap<String,String> map2 = new HashMap<>();
        map2.put("a","1");
        map2.put("b","2");
        map2.put("c","3");
        map2.put("d","4");
        map2.put("e","5");

        // 1.增强for
        for (String k: map2.keySet()){
            // map2.remove(k);
            System.out.println(k + ": "+ map2.get(k));
        }
        System.out.println("************");
        // 2.迭代器
        // 遍历Map
        Set<String> keyset = map2.keySet();
        System.out.println(keyset.getClass());
        Iterator<String> it = keyset.iterator();
        while (it.hasNext()){
            String key = it.next();
            // 迭代器删除键值
            it.remove();
            System.out.println(key +": "+ map2.get(key));

        }
        System.out.println(map2);
        System.out.println("**************");


        HashMap<String,String> map3 = new HashMap<>();
        map3.put("a","11");
        map3.put("b","22");
        map3.put("c","33");
        map3.put("d","44");
        map3.put("e","55");
        // 3.Entry<K,V>
        // 首先获取映射关系集合entryKey
        Set<Map.Entry<String,String>> entryKey = map3.entrySet();
        // 然后获取entryKey的迭代器对象
        Iterator<Map.Entry<String,String>> entryIt = entryKey.iterator();
        // 迭代器遍历
        while (entryIt.hasNext()){
            Map.Entry<String,String> entry = entryIt.next();
            System.out.println("key: "+ entry.getKey() + ", " + "value: " + entry.getValue() );
        }

        System.out.println("***************");
        // 直接增强for
        for (Map.Entry<String,String> i : map3.entrySet()) {
            System.out.println("key: "+ i.getKey() + ", " + "value: " + i.getValue() );
        }

    }
}
