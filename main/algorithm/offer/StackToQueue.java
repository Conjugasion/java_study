package algorithm.offer;

import java.util.Stack;

/**
 * @author Lucas
 * @date 2019-05-29 20:33
 * 用两个栈实现队列
 * 两只水杯倒来倒去
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int first =  stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return first;
    }

    public static void main(String[] args) {
        StackToQueue p5 = new StackToQueue();
        p5.push(1);
        p5.push(2);
        System.out.println(p5.pop());

        p5.push(3);
        p5.push(4);
        p5.push(5);

        System.out.println(p5.pop());
        System.out.println(p5.pop());
        System.out.println(p5.pop());
        System.out.println(p5.pop());

    }
}
