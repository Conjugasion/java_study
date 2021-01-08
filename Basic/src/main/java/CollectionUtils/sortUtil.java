package CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther Lucas
 * @date 2019/1/4 21:24
 */
public class sortUtil {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("ert");
        list.add("dfg");
        list.add("cxz");
        list.add("bvc");

        System.out.println(list);
        // 排序
        Collections.sort(list);
        System.out.println(list);
    }

}
