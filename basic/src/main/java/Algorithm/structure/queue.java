package Algorithm.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 * @date 2019-05-26 18:33
 * 队列，先进先出
 */
public class queue {
    private List<Object> list = new ArrayList<>();
    public queue(List<Object> list){
        this.list = list;
    }

    public queue(){

    }

    // 进队
    public void in(Object obj){
        list.add(obj);
    }

    //出队
    public Object out(){
        if (list.size() == 0){
            return null;
        }
        return list.remove(0);
    }

    public static void main(String[] args) {
        queue q = new queue();
        q.in(1);
        q.in(2);
        q.in(3);
        q.in(4);
        q.in(5);
        System.out.println(q.out());
        System.out.println(q.out());
        System.out.println(q.out());
        System.out.println(q.out());
        System.out.println(q.out());
        System.out.println(q.out());
    }
}
