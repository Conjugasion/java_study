package algorithm.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucas
 * @date 2019-05-26 18:17
 * 栈
 * 先进后出
 */
public class stack {
    private List<Object> list = new ArrayList<>();
    public stack(List<Object> list) {
        this.list = list;
    }

    public stack(){

    }

    // 出栈
    public Object pop(){
        if (list.size() == 0){
            return null;
        }
        else return list.remove(list.size() - 1);
    }

    // 压栈
    public void push(Object obj){
        list.add(obj);
    }

    public static void main(String[] args) {
        stack s = new stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
