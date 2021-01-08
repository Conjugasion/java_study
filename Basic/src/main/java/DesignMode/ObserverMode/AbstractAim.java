package DesignMode.ObserverMode;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019/7/29 15:30
 * 抽象被观察者类
 */
public abstract class AbstractAim {
    // 用于存放观察者
    public ArrayList<Observer> observers = new ArrayList<>();

    // 增加观察者
    void attach(Observer observer){
        observers.add(observer);
    }

    // 删除观察者
    void delete(Observer observer){
        observers.remove(observer);
    }

    // 抽象通知方法
    abstract void notice();
}
