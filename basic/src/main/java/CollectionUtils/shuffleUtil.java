package CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther Lucas
 * @date 2019/1/4 21:32
 */
public class shuffleUtil {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("asd");
        list.add("ert");
        list.add("dfg");
        list.add("cxz");
        list.add("bvc");

        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
