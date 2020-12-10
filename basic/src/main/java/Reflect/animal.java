package Reflect;

/**
 * @auther Lucas
 * @date 2019/1/16 9:39
 */
public class animal {
    public int d = 400;
    private int e = 500;

    public animal(int num){

    }

    public int eat(){
        System.out.println("吃");
        return 1;
    }

    private void sleep(){
        System.out.println("睡觉");
    }
}
