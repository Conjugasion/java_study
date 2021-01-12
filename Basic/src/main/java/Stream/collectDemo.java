package Stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.*;

/**
 * @auther Lucas
 * @date 2019/2/21 13:56
 */
public class collectDemo {
    public static void main(String[] args) {
        String[] arr ={"aa","ccc","sss"};
        System.out.println(Arrays.stream(arr).collect(joining()).getClass());
        System.out.println(Arrays.stream(arr).collect(toList()).getClass());
        System.out.println(Arrays.asList(arr));

        List<String> al = Arrays.asList("a", "b", "c", "d");
        al.forEach(collectDemo::printValur);
        //下面的方法和上面等价的
        Consumer<String> methodParam = collectDemo::printValur; //方法参数
        al.forEach(x -> methodParam.accept(x));//方法执行accept
    }

    public static void  printValur(String str){
        System.out.println("print value : "+str);
    }
}
