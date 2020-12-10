package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Lucas
 * @date 2019/9/3 14:32
 *ListIterator增强型迭代器
 *
 *   ele1    ele2    ele3
 * it     it      it
 *
 * add(E e): 将指定的元素插入列表，插入位置为迭代器当前位置 之前
 *
 * hasNext()：以正向遍历列表时，如果列表迭代器后面还有元素，则返回 true，否则返回false
 *
 * hasPrevious():如果以逆向遍历列表，列表迭代器前面还有元素，则返回 true，否则返回false
 *
 * next()：返回列表中ListIterator指向位置后面的元素
 *
 * nextIndex():返回列表中ListIterator所需位置后面元素的索引 0,1,2...
 *
 * previous():返回列表中ListIterator指向位置前面的元素
 *
 * previousIndex()：返回列表中ListIterator所需位置前面元素的索引
 *
 * remove():从列表中删除next()或previous()返回的最后一个元素（有点拗口，意思就是对迭代器使用hasNext()方法时，删除ListIterator指向位置后面的元素；当对迭代器使用hasPrevious()方法时，删除ListIterator指向位置前面的元素）

 * set(E e)：从列表中将next()或previous()返回的最后一个元素返回的最后一个元素更改为指定元素e
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Lucas");
        names.add("Selina");
        names.add("Mark");
        names.add("Mary");
        names.add("Leo");

        ListIterator<String> it = names.listIterator();
        // Iterator<String> it = names.iterator();
        while (it.hasNext()){
            String name = it.next();
            if (name.equals("Selina")){
                it.remove();
            }else if (name.equals("Lucas")){
                // names.set(1, "tangtang");   // [tangtang, Mark, Mary, Leo]
                // it.previous();                 // 迭代器往前退一步
                it.add("tangtang");             // [Lucas, tangtang, Mark, Mary, Leo]
                System.out.println("当前迭代器所在索引：" + it.nextIndex());
                // it.next();                     // 迭代器往后走一步
                // it.set("tangtang");          // [tangtang, Mark, Mary, Leo]
            }
        }
        System.out.println(names);
    }
}
