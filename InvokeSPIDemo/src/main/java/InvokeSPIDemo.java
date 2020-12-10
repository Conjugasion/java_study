import java.util.*;

/**
 * @author tangdongfan
 * @date 2020/12/10 15:31
 */
public class InvokeSPIDemo {
    private static ServiceLoader<Comparator> serviceLoader = ServiceLoader.load(Comparator.class);

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setName("1");
        s2.setName("2");

        List<Student> students = new ArrayList<>();
        students.add(s2);
        students.add(s1);

        students.forEach(x-> System.out.println(x.getName()));
        Collections.sort(students, getCompartor());
        students.forEach(x-> System.out.println(x.getName()));
    }

    private static Comparator<Student> getCompartor() {
        for(Comparator service : serviceLoader) {
            return (Comparator<Student>)service;
        }
        return null;
    }
}
