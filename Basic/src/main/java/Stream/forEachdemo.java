package Stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @auther Lucas
 * @date 2019/2/20 16:49
 */
public class forEachdemo {
    public static void main(String[] args) {
        // new Thread(() -> System.out.println("run")).start();

        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};
        Arrays.sort(players, new Comparator<String>() {
            @Override
            // 自定义排序
            public int compare(String s1, String s2) {
                return (s1.substring(0,1).compareTo(s2.substring(0,1)));
            }
        });
//        int a = "aag".compareTo("abg");
//        System.out.println(a);

         Arrays.sort(players, (s1, s2) -> (s1.compareTo(s2)));

        Arrays.asList(players).forEach((i) -> System.out.println(i));
        System.out.println("自定义MyConsumer1");
        Arrays.asList(players).forEach(new MyConsumer1());
        System.out.println("自定义MyConsumer2");
        Arrays.asList(players).forEach(new MyConsumer2());
        System.out.println("自定义MyConsumer3");
        Consumer<String> MyConsumer3 = i -> System.out.println(i.split(" ")[0]);
        Arrays.asList(players).forEach(MyConsumer3);
        System.out.println("************");
        System.out.printf("%.1f, %.2f", 1.32,1.365);

    }
    public static class MyConsumer1 implements Consumer<String>{
        @Override
        public void accept(String s) {
            System.out.println("自定义Consumer的accept方法：" + s);
        }

    }

    private static class MyConsumer2 implements Consumer<String> {
        @Override
        public void accept(String s) {
            StringBuffer sb = new StringBuffer();
            char[] chars = s.toCharArray();
            for(char c : chars){
                if(97 <= c && c <= 122){
                    String s1 = Character.toString(c);
                    sb.append(s1.toUpperCase());
                }
                else if(65 <= c && c <= 90) {
                    sb.append((char)(c+32));
                }
            }
            System.out.println("大写变小写，小写变大写: " + sb);
        }
    }

}
