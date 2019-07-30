package Algorithm.offer;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019-06-23 16:56
 * 两个水杯倒来倒去
 */
public class StackBecomeQueue {
    public static void main(String[] args) {
        StackBecomeQueue queue = new StackBecomeQueue();
        queue.offer(1);
        queue.offer(2);
        System.out.println(queue.get());
        queue.offer(3);
        queue.offer(4);
        System.out.println(queue.get());
        queue.offer(5);

        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
    }

    class Stack{
        ArrayList<Integer> list = new ArrayList<>();
        int size = 0;

        int pop(){
            size--;
            return list.remove(list.size()-1);
        }

        void push(int i){
            size++;
            list.add(i);
        }
    }

    Stack s1 = new Stack();
    Stack s2 = new Stack();

    // 获得很简单
    int get(){
        return s1.pop();   // 以s1为主
    }

    // 加入
    void offer(int i){
        if (s1.size!=0){
            int size1 = s1.size;     // size会变
            for (int j = 0; j < size1; j++) {
                s2.push(s1.pop());
            }
            s2.push(i);
            int size2 = s2.size;
            for (int j = 0; j < size2; j++) {
                s1.push(s2.pop());
            }
        }
        else s1.push(i);
    }
}
