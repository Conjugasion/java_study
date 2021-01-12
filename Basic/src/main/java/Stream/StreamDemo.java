package Stream;

import java.util.*;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Lucas
 * @date 2019/9/3 13:34
 */
public class StreamDemo {
    public static void main(String[] args) {
        Student stuA = new Student(1, "Lucas", "M", 184);
        Student stuB = new Student(2, "Selina", "F", 163);
        Student stuC = new Student(3, "Mark", "M", 175);
        Student stuD = new Student(4, "Mary", "F", 158);
        Student stuE = new Student(5, "Leo", "M", 170);
        List<Student> students = new ArrayList<>();
        students.add(stuA);
        students.add(stuB);
        students.add(stuC);
        students.add(stuD);
        students.add(stuE);

        // 通过of()生成指定stream
        Stream<List<Student>> listStream = Stream.of(students);
        listStream.forEach(System.out::println);   // 打印的是List<Student>

        System.out.println("通过generate()生成一个无限长度的Stream，返回符合某种规则的值");
        // Stream.generate(()->Math.random());
        Stream<Double> generate = Stream.generate(new Supplier<Double>() {
            int i = 10;
            @Override
            public Double get() {
                Random r = new Random();
                return r.nextInt(i)+0.5;
            }
        });
        generate.limit(10).forEach(num-> System.out.print(num.intValue()+"; "));
        System.out.println();

        System.out.println("通过iterate()生成一个无限长度的Stream,通过函数f迭代对给指定的元素种子而产生无限连续有序Stream");
        // Stream<Integer> it = Stream.iterate(2, seed -> seed + 1);
        Stream<Integer> it = Stream.iterate(1, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer seed) {
                return seed + 1;        // 指定规则
            }
        });
        it.limit(10).forEach(num -> System.out.print(num+"; "));
        System.out.println();

        // Collection接口和Arrays的默认方法
        // collection.stream()和Arrays.stream(T[] array);
        // list.forEach(student -> System.out.println(student.name));
        System.out.println("collection.stream() 集合转流");
        students.stream().forEach(student -> System.out.print(student.name+"; "));
        System.out.println();

        System.out.println("Arrays.stream(T[] array) 数组转流");
        int ids[] = new int[]{1, 2, 3, 4};
        Arrays.stream(ids).forEach(s-> System.out.print(s+"; "));
        System.out.println();

        System.out.println("concat方法将两个Stream连接在一起，合成一个Stream");
        Stream.concat(Stream.of(1, 2, 3), Stream.of(4, 5))
                .forEach(i -> System.out.print(i + "  "));
        System.out.println();

        System.out.println("distinct方法以达到去除掉原Stream中重复的元素");
        Arrays.stream(new int[]{1,2,3,1,2,3})
                .distinct()
                .forEach(num -> System.out.print(num+"; "));
        System.out.println();

        System.out.println("filter方法对原Stream按照指定条件过滤");
        ArrayList<Integer> filtered = new ArrayList<>();
        Arrays.stream(new int[]{1,2,3,1,2,3,4,5}).filter(num -> num>3).forEach(filtered::add);
        System.out.println(filtered);

        System.out.println("使用stream, int[]转Integer[]");
        int[] originInt = {1,2,3,4,5,2,1};
        Integer[] boxedInt = Arrays.stream(originInt).boxed().toArray(Integer[]::new);
        System.out.println(Arrays.toString(boxedInt));

        System.out.println("使用stream, Integer[]转int[]");
        Integer[] boxed = Arrays.stream(originInt).boxed().toArray(Integer[]::new);
        int[] unboxed = Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(unboxed));

        System.out.println("ArrayList转Integer");
        ArrayList<Integer> boxedList = new ArrayList<>(Arrays.asList(boxed));
        Integer[] boxedArr = boxedList.toArray(new Integer[0]);
        System.out.println(Arrays.toString(boxedArr));

        System.out.println("collect(Collectors.toList()), int[]转ArrayList");
        List<Integer> intList = Arrays.stream(originInt).boxed().collect(Collectors.toList());
        System.out.println(intList);

        OptionalInt max = Arrays.stream(originInt).max();
        System.out.println("数组最大值：" + max.getAsInt());
        Optional<Integer> listMax = boxedList.stream().max((o1, o2) -> o1 - o2);
        System.out.println("列表最大值：" + listMax.get());

        System.out.println("filter过滤Stream并返回新的Stream");
        List<Student> filterList = students.stream().filter(student -> student.height > 180 && student.sex.equals("M")).collect(Collectors.toList());
        System.out.println(filterList);
    }

    static class Student {
        int no;
        String name;
        String sex;
        float height;

        Student(int no, String name, String sex, float height) {
            this.no = no;
            this.name = name;
            this.sex = sex;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", sex='" + sex + '\'' +
                    ", height=" + height +
                    '}';
        }
    }
}
