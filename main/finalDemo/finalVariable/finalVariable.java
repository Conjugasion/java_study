package finalDemo.finalVariable;

import finalDemo.finalMethod.son;

/**
 * @auther Lucas
 * @date 2018/12/28 15:37
 * final 修饰变量无法被修改
 * final 修饰引用变量，变量指向的内存地址终生不变
 */
public class finalVariable {
    public static void main(String[] args) {

        final  int i = 10;
        // i = 20;

        final son s1 = new son();
        son s2 = new son();
        // 报错
        // s1 = s2;
    }
}
