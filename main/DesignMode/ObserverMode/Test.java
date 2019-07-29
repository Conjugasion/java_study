package DesignMode.ObserverMode;

/**
 * @author Lucas
 * @date 2019/7/29 15:39
 */
public class Test {
    public static void main(String[] args) {
        // 创建被观察类
        Cat cat = new Cat();
        Dog dog = new Dog();
        Mouse mouse = new Mouse();
        // 将对象加入观察者队列
        cat.observers.add(dog);
        cat.observers.add(mouse);
        // 当时机成熟时发送notice
        cat.notice();
    }
}
