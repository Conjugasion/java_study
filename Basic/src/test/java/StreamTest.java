import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.*;

/**
 * @author tangdongfan
 * @date 2021/1/11 21:01
 * @description Stream分享
 */

public class StreamTest {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Person {
        // 姓名
        private String name;
        // 薪资
        private int salary;
        // 年龄
        private int age;
        //性别
        private String sex;
        // 地区
        private String area;
    }

    //多参数无返回
    @FunctionalInterface
    public interface NoReturnMultiParam {
        void method(int a, int b);
    }

    //无参无返回值
    @FunctionalInterface
    public interface NoReturnNoParam {
        void method();
    }

    //一个参数无返回
    @FunctionalInterface
    public interface NoReturnOneParam {
        void method(int a);
    }

    //多个参数有返回值
    @FunctionalInterface
    public interface ReturnMultiParam {
        int method(int a, int b);
    }

    //无参有返回
    @FunctionalInterface
    public interface ReturnNoParam {
        int method();
    }

    //一个参数有返回值
    @FunctionalInterface
    public interface ReturnOneParam {
        int method(int a);
    }

    List<Person> personList = new ArrayList<>();
    Map<String, Person> personMap = new HashMap<>();

    @Before
    public void initPersonList() {
        personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 21, "male", "New York"));
        personList.add(new Person("Jack", 7000, 22, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 23, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        personMap = personList.stream().collect(Collectors.toMap(Person::getName, p -> p));
    }

    /*
     * 函数式接口
     * 1.只包含一个抽象方法的接口
     * 2.可以通过m匿名内部类/Lambda表达式来创建该接口的对象
     * 3.可以在任意函数式接口上使用@FunctionalInterface注解, 这样做可以检查它是否是一个函数式接口
     * 4.四大核心函数式接口:
     *   Consumer<T>: 消费型接口, void accept(T t);
     *   Supplier<T>: 供给型接口, T get();
     *   Function<T, R>: 函数型接口, R apply(T t);
     *   Predicate<T>: 断言型接口, boolean test(T t);
     * */
    @Test
    public void useFunctionalInterface() {
        // Consumer<T>: 消费型接口
        Consumer<Person> consumer = new Consumer<Person>() {
            @Override
            public void accept(Person person) {
                System.out.println(person.toString());
            }
        };
        // Supplier<T>: 供给型接口
        Supplier<Person> supplier = new Supplier<Person>() {
            @Override
            public Person get() {
                return new Person();
            }
        };
        // Function<T, R>: 函数型接口
        Function<Person, String> function = new Function<Person, String>() {
            @Override
            public String apply(Person p) {
                return p.getName();
            }
        };
        // Predicate<T>: 断言型接口
        Predicate<Person> predicate = new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return "male".equals(p.getSex());
            }
        };
    }

    /*
    * Lambda表达式
    * 1.用于取代匿名内部类。
    * 2.可以对某些接口进行简单的实现, 但并不是所有的接口都可以使用Lambda表达式实现。
    * 3.Lambda规定接口中只能有一个需要被实现的方法, 不是规定接口中只能有一个方法。
    * 4.语法形式 ()->{}, 其中 () 用来描述参数列表, {} 用来描述方法体, -> 为 lambda运算符
    * */
    @Test
    public void useLambda() {
        // Lambda表达式实现 无参无返回 的接口
        NoReturnNoParam noReturnNoParam = () -> {
            System.out.println("NoReturnNoParam");
        };
        noReturnNoParam.method();

        // Lambda表达式实现 一个参数无返回 的接口
        // 简化方法体大括号, 如果方法条只有一条语句, 则可以省略方法体大括号
        NoReturnOneParam noReturnOneParam = (int a) -> System.out.println("NoReturnOneParam param:" + a);
        noReturnOneParam.method(6);

        // Lambda表达式实现 多个参数无返回 的接口
        // 简化参数类型, 可以不写参数类型, 但是必须所有参数都不写
        NoReturnMultiParam noReturnMultiParam = (a, b) -> System.out.println("NoReturnMultiParam param:" + "{" + a +"," + + b +"}");
        noReturnMultiParam.method(6, 8);

        // Lambda表达式实现 无参有返回值 的接口
        ReturnNoParam returnNoParam = () -> {
            System.out.print("ReturnNoParam");
            return 1;
        };
        int res = returnNoParam.method();
        System.out.println("return:" + res);

        // Lambda表达式实现 一个参数有返回值 的接口
        // 简化参数小括号, 如果只有一个参数则可以省略参数小括号
        ReturnOneParam returnOneParam = a -> {
            System.out.println("ReturnOneParam param:" + a);
            return 1;
        };
        int res2 = returnOneParam.method(6);
        System.out.println("return:" + res2);

        // Lambda表达式实现 多个参数有返回值 的接口
        ReturnMultiParam returnMultiParam = (int a, int b) -> {
            System.out.println("ReturnMultiParam param:" + "{" + a + "," + b +"}");
            return 1;
        };
        int res3 = returnMultiParam.method(6, 8);
        System.out.println("return:" + res3);

        /*
        * 方法引用
        * 有时候我们不是必须要自己重写某个匿名内部类的方法, 我们可以利用lambda表达式的接口快速指向一个已经被实现的方法。
        * 语法: 方法归属者::方法名
        * */
        // 静态方法的归属者为类名, 以下代码相当于noReturnNoParam = () -> System.out.println();
        noReturnNoParam = System.out::println;
        // 普通方法归属者为对象本身, 以下代码相当于() -> getDefaultValue()
        noReturnNoParam = this::getDefaultValue;
    }

    /*
     * 在使用stream之前, 先理解一个概念: Optional
     * Stream中的元素是以Optional类型存在的
     * Optional相当于一个容器,可以一个接收的对象value,用泛型指定类型,并且该对象有可能为空。
     * 如果值存在则isPresent()方法会返回true, 调用get()方法会返回该对象。
     * */
    @Test
    public void useOptional() {
        /*
         * 实际开发场景中,我们经常需要调用别的方法, 但有些方法返回数据可能为null, 我们需要判断一下, 不然就有可能NPE了
         * 比如说, 当返回数据为空时,为其设置默认值
         * */
        String result1 = null;
        String result2 = "方法返回值";

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<String> optional1 = Optional.ofNullable(result1);
        // Optional.of - 不允许传递为 null 参数, 如果传递的参数是 null, 抛出异常 NullPointerException
        Optional<String> optional2 = Optional.of(result2);

        // Optional.isPresent - 判断值是否存在
        System.out.println("result1是否存在: " + optional1.isPresent());
        System.out.println("result2是否存在: " + optional2.isPresent());
        System.out.println("-------------------------------");

        // Optional.orElse - 如果值存在则返回它, 否则返回默认值
        String value1 = optional1.orElse("默认值");
        String value2 = optional2.orElse("默认值");
        System.out.println("optional1.orElse: " + value1);
        System.out.println("optional2.orElse: " + value2);
        System.out.println("-------------------------------");

        /*
         * Optional.orElseGet - 如果值存在则返回它, 否则返回默认值
         * orElse VS orElseGet
         * 可以看到,虽然optional2不为空,但是orElse()依然调用了getDefaultValue()方法,orElseGet()并没有调用方法
         * */
        value1 = optional2.orElse(getDefaultValue());
        value2 = optional2.orElseGet(()->getDefaultValue());
        System.out.println("optional2.orElse: " + value1);
        System.out.println("optional2.orElseGet: " + value2);

        // 实战举例
        Person person = Optional.ofNullable(personMap.get("Lucas")).orElseGet(Person::new);
    }
    // 模拟远程方法调用
    public String getDefaultValue(){
        System.out.println("getDefaultValue()被调用了!");
        return "默认值";
    }

    /*
    * 1.将要处理的元素集合看作一种流, 在流的过程中, 借助Stream API对流中的元素进行操作, 比如: 筛选、排序、聚合等。
    * 2.Stream的特性
    *   不是数据结构, 不会保存数据。
    *   不会改变数据源, 通常情况下会产生一个新的集合或一个值。
    *   惰性求值, 流在中间处理过程中, 只是对操作进行了记录, 并不会立即执行, 需要等到执行终止操作的时候才会进行实际的计算。
    * */
    @Test
    public void createStream() {
        /*
        * 集合类创建流
        */
        List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());
        // 创建一个顺序流, 由主线程按顺序对流执行操作
        Stream<String> listStream = list.stream();
        // 创建一个并行流, 内部以多线程并行执行的方式对流进行操作, 最后再将结果合并。前提是流中的数据处理没有顺序要求
        Stream<String> listParallelStream = list.parallelStream();

        /*
        * 数组创建流
        */
        int[] intArray={1,3,5,6,8};
        IntStream intStream = Arrays.stream(intArray);
        String[] strArray={"1","3","5","6","8"};
        Stream<String> stringStream = Arrays.stream(strArray);

        /*
        * 使用Stream的静态方法创建流: empty()、of()、iterate()、generate()
        */
        // 创建一个空的stream
        Stream<Integer> emptyStream  = Stream.empty();
        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6);
        // 产生规律的数据
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        // 创建无限流, 通过limit提取指定大小
        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
    }

    /*
    * 常用的Stream操作
    *   中间操作: 每次返回一个新的流, 可以有多个中间操作, 常用方法有filter()、map()、flatMap()、distinct()、sorted()、limit()等。
    *   结束操作: 每个流只能进行一次终端操作, 终端操作结束后, 流无法再次使用。终端操作会产生一个新的集合或值。常用方法有forEach()、
    *            toArray()、collect()、max()、min()、count()、anyMatch()、findFirst()、findAny()等。
    * */

    /*
    * 筛选/遍历/查找/匹配(filter/forEach/find/match)
    * */
    @Test
    public void method1() {
        List<Integer> list = Stream.of(7, 6, 9, 3, 8, 2, 1).collect(Collectors.toList());
        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::print);
        System.out.println();
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（可以用并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值: " + findFirst.get());
        System.out.println("匹配任意一个值: " + findAny.get());
        System.out.println("是否存在大于6的值: " + anyMatch);
    }

    /*
    * 聚合(max/min/count)
    * */
    @Test
    public void method2() {
        List<String> list = Stream.of("adnm", "admmt", "pot", "xbangd", "weoujgsd").collect(Collectors.toList());
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        Optional<String> min = list.stream().min(Comparator.comparing(String::length));
        long count = list.stream().filter(x -> x.length() > 4).count();
        System.out.println("最长的字符串: " + max.get());
        System.out.println("最端的字符串: " + min.get());
        System.out.println("长度大于4的字符串数量: " + count);
    }

    /*
    * 映射(map/flatMap)
    * */
    @Test
    public void method3() {
        List<String> list1 =  Stream.of("a", "b").collect(Collectors.toList());
        List<String> list2 = Stream.of("c", "d").collect(Collectors.toList());
        List<List<String>> lists = Stream.of(new ArrayList<>(list1), new ArrayList<>(list2)).collect(Collectors.toList());
        // map
        // [A, B]
        List<String> transList1 = list1.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(transList1);
        // [C, D]
        List<String> transList2 = list2.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(transList2);

        // flatMap
        // [A, B, C, D]
        List<String> transLists1 = lists.stream().flatMap(Collection::stream).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(transLists1);
        // Map [[A, B], [C, D]]
        List<List<String>> transLists2 = lists.stream().map(x -> x.stream().map(String::toUpperCase).collect(Collectors.toList())).collect(Collectors.toList());
        System.out.println(transLists2.toString());
        /*
        * 有二箱鸡蛋，每箱2个，现在要把鸡蛋加工成煎蛋，然后分给学生。
        * map做的事情：把二箱鸡蛋分别加工成煎蛋，还是放成原来的两箱，分给2组学生；
        * flatMap做的事情：把二箱鸡蛋分别加工成煎蛋，然后放到一起【4个煎蛋】，分给4个学生；
        * */

    }

    /*
    * 归约(reduce)
    * */
    @Test
    public void method4() {
        List<Integer> list = Stream.of(1, 3, 2, 8, 11, 4).collect(Collectors.toList());
        // 求和方式1  29
        Optional<Integer> sum1 = list.stream().reduce((x, y) -> x + y);
        // 求和方式2  29
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求乘积  2112
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);
        System.out.println("list求和, sum1 = " + sum1.get() + ", sum2 = " + sum2.get());
        System.out.println("list求乘积, product = " + product.get());
    }

    /*
    * 收集(collect)
    *   归集: toList/toSet/toMap/...
    *   统计: count/averaging/maxBy/summingInt/summarizingInt/...
    *   分组: partitioningBy/groupingBy/...
    *   结合: joining
    * */
    @Test
    public void method5() {
        /*
        * 归集: toList/toSet/toMap/...
        * */
        List<Integer> list1 = Stream.of(1, 6, 3, 4, 6, 7, 9, 6, 20).collect(Collectors.toList());
        // toList
        List<Integer> listNew = list1.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        // toSet
        Set<Integer> set = list1.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());
        // toMap
        Map<String, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getName, p -> p));

        /*
        * 统计: count/averaging/maxBy/summingInt/summarizingInt/...
        * */
        // 求总数
        Long count = personList.stream().collect(Collectors.counting());
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));
        System.out.println("员工总数: " + count);
        System.out.println("员工平均工资: " + average);
        System.out.println("员工工资总和: " + sum);
        System.out.println("员工工资所有统计: " + collect);
        System.out.println("-------------------------");

        /*
        * 分组: partitioningBy/groupingBy/...
        * */
        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group1 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组, 再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("员工按薪资是否大于8000分组情况如下: ");
        part.forEach((aBoolean,persons) -> persons.forEach(person->System.out.println(aBoolean + "=[" + person.toString() + "]")));
        System.out.println("员工按性别分组情况如下: ");
        group1.forEach((gender,persons) -> persons.forEach(person->System.out.println(gender + "=[" + person.toString() + "]")));
        System.out.println("员工按性别、地区如下: ");
        group2.forEach((gender,map) -> map.forEach((area, persons) -> persons.forEach(person -> System.out.println(gender + "_" + area + "=[" + person.toString() + "]"))));
        System.out.println("-------------------------");

        /*
        * 结合: joining
        * */
        List<String> list2 = Stream.of("A", "B", "C").collect(Collectors.toList());
        String string = list2.stream().collect(Collectors.joining("-"));
        System.out.println("拼接后的字符串: " + string);
    }

    /*
     * 排序(sorted)
     *   sorted(): 自然排序, 流中元素需实现Comparable接口
     *   sorted(Comparator comparator): Comparator排序器自定义排序
     * */
    @Test
    public void method6() {
        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList3 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());
        System.out.println("按工资升序排序: " + newList);
        System.out.println("按工资降序排序: " + newList2);
        System.out.println("先按工资再按年龄自定义降序排序: " + newList3);
    }

    /*
    * 提取/组合(concat/limit/skip)
    * */
    @Test
    public void method7() {
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct: 去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit: 限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip: 跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(2).limit(5).collect(Collectors.toList());

        System.out.println("流合并: " + newList);
        System.out.println("limit: " + collect);
        System.out.println("skip: " + collect2);
    }
}
