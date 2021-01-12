package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Lucas
 * @date 2019/9/3 11:20
 */
public class LambdaDemo {
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach(player -> System.out.print(player + ";"));
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        players.forEach(System.out::println);

        List<String> modifyPlayers =  new ArrayList<>();
        players.forEach(player -> modifyPlayers.add(player + " modify"));
        System.out.println(modifyPlayers);

        // 匿名内部类
        new Thread(() -> System.out.println("匿名内部类实现Runnable接口 !")).start();

        Arrays.sort(atp, (s1, s2) -> s1.compareTo(s2));

    }
}
