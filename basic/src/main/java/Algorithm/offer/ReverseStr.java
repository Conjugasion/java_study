package Algorithm.offer;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Lucas
 * @date 2019-06-19 20:22
 * 字符串左移/右移
 */
public class ReverseStr {
    public static void main(String[] args) {
        String[] s = {"a", "b", "c", "d", "e", "f"};
        // 左移两位 （a'b'）'   (ba fedc)'  cdefab
        //reverse(s, 0, 1);
        //reverse(s, 2, 5);
        //reverse(s, 0, 5);
        System.out.println(Arrays.toString(s));
        Arrays.asList(s).sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -1;
            }
        });
        System.out.println(Arrays.toString(s));
    }

    static void reverse(String[] s, int from, int to){
        while (from < to){
            String f = s[from];
            s[from] = s[to];
            s[to] = f;
            from++;
            to--;
        }
    }
}
