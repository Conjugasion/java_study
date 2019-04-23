package concurrentDemo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lucas
 * @date 2019/4/22 9:37
 */
public class SynchronizedMapDemo {
    public static void main(String[] args) {
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
    }
}
