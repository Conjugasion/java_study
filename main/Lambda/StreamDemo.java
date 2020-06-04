package Lambda;

import java.util.Arrays;

/**
 * @author tangdongfan
 * @date 2020/6/3 17:15
 */
public class StreamDemo {
    public static void main(String[] args) {
        String[] strs = { "aaa", "bbb", "ccc" };
        /*
        [Ljava.lang.String;@4c203ea1
        [Ljava.lang.String;@27f674d
        [Ljava.lang.String;@1d251891
        * */
        Arrays.stream(strs).map(str -> str.split("")).forEach(System.out::println);
        Arrays.stream(strs).map(str -> str.split("")).flatMap(Arrays::stream).forEach(System.out::println);// aaabbbccc
        Arrays.stream(strs).map(str -> str.split("")).flatMap(str -> Arrays.stream(str)).forEach(System.out::println);// aaabbbccc
    }
}
