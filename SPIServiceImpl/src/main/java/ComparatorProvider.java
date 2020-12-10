import java.util.Comparator;

/**
 * @author tangdongfan
 * @date 2020/12/10 15:25
 */
public class ComparatorProvider implements Comparator<Student> {

    public int compare(Student o1, Student o2) {
        System.out.println("自定义compare");
        return o1.getName().compareTo(o2.getName());
    }
}
