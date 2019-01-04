package mapDemo;

import java.util.Hashtable;
import java.util.Map;

/**
 * @auther Lucas
 * @date 2019/1/4 20:46
 * 线程安全，运行速度慢
 * 底层是哈希表
 * 不允许存储null键，null值
 */
public class hashtableDemo {
    public static void main(String[] args) {
        Map<String,String> hackable = new Hashtable<>();
        // hackable.put(null,"asd");
        // hackable.put("asd",null);

    }
}
