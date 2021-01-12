package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tangdongfan
 * @date 2020/6/3 17:15
 */
public class Test {
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
        System.out.println("--------------------");
        List<String> pins = new ArrayList<>();
        pins.add("1");
        pins.add("2");
        pins.add("3");
        List<Boolean> isAllowed = pins.stream().map(p -> isAllowed(p)).collect(Collectors.toList());
        System.out.println(isAllowed);
        Boolean[] booleans = isAllowed.toArray(new Boolean[1]);
        System.out.println(Arrays.toString(booleans));

        System.out.println("--------------------");
        int[] array1 = {1,2,3,4,5,6};
        Integer[] integers = Arrays.stream(array1).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));
        String[] array2 = {"a", "b", "c", "d"};
        String[] strings = Arrays.stream(array2).map(ele -> ele.toUpperCase()).toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }

    static boolean isAllowed(String pin){
        if (pin.compareTo("2") >=0 ) {
            return true;
        } else {
            return false;
        }
    }
}
