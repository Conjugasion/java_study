package Lambda;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


/**
 * @auther Lucas
 * @date 2019/2/21 10:28
 */
public class filterDemo {
    public static void main(String[] args) {
        Integer[] sa = {1000, 1600, 1800, 900, 2500, 1800, 2800, 3500, 1300, 1200, 2000, 3000};
        List<Integer> salary = Arrays.asList(sa);


        HashSet<Integer> salarySet = new HashSet<>(salary);
        salarySet.forEach((Integer i) -> System.out.println(i));

        salary.stream().filter((i) -> (i >=1500)).forEach((i) -> System.out.println("大于1500： " + i));
        System.out.println("********");
        salarySet.stream().filter((i) -> (i >=1500)).forEach((i) -> System.out.println("大于1500： " + i));
        System.out.println("自定义Predicate1");
        salary.stream().filter(new MyPredicate1()).forEach((i) -> System.out.println("大于1500： " + i));
        System.out.println("自定义Predicate2");
        Predicate<Integer> MyPredicate2 = i -> i >= 2000;
        salary.stream().filter(MyPredicate2).forEach(i -> System.out.println("大于2000：" + i));
        System.out.println("limit限制fliter出来的数量为3个");
        salary.stream().filter(MyPredicate2).limit(3).forEach(i -> System.out.println("大于2000：" + i));
        System.out.println("排序");
        salary.stream().filter(MyPredicate2).limit(3).sorted((Integer i1,Integer i2) -> i2.compareTo(i1)).forEach(i -> System.out.println("大于2000(从高到低排序)：" + i));
        System.out.println("取最低值");
        Integer minSalary = salary.stream().filter(MyPredicate2).limit(3).min((Integer i1, Integer i2) -> i1.compareTo(i2)).get();
        System.out.println(minSalary);
        System.out.println("Map,给所有工资加500");
        Set<Integer> salarySet1 = salary.stream().map(i -> i + 500).collect(Collectors.toSet());
        System.out.println(salarySet1);
        System.out.println("自定义map方法 + 加分隔符");
        String[] ns = {"tom", "jack", "bob", "selina", "leo", "lucas", "tony", "lina", "mark", "king", "newton", "harry"};
        List<String> names = Arrays.asList(ns);
        String namesStr = names.stream().map(s ->  {
             {
                StringBuilder sb = new StringBuilder();
                char[] chars = s.toCharArray();
                sb.append(String.valueOf(chars[0]).toUpperCase());
                for (int i = 1; i < chars.length; i++) {
                    sb.append(chars[i]);
                }
                return sb.toString();
            }
        }).collect(joining(";"));
        System.out.println(namesStr);
    }
    static class MyPredicate1 implements Predicate<Integer>{
        @Override
        public boolean test(Integer i) {
            return i >= 1000;
        }
    }
}
