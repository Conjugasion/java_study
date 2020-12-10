package CollectionDemo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @auther Lucas
 * @date 2019/1/4 9:12
 */
public class collection {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();
        coll.add("abc");

        Object[] str = coll.toArray();
        ArrayList<String> newColl = (ArrayList<String>)coll;
        newColl.remove(0);
    }
}
