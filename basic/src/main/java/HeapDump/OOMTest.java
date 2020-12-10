package HeapDump;

import java.util.Date;
import java.util.HashMap;

/**
 * @author Lucas
 * @date 2019/6/17 15:15
 */
public class OOMTest {
    public static void main(String[] args) {
            /*
        内存泄漏测试
        -Xms2m  -Xmx2m  -XX:+HeapDumpOnOutOfMemoryError
        溢出日志在目录下
         */
        HashMap<String, Date> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            map.put(String.valueOf(i), new Date());
        }
    }
}
