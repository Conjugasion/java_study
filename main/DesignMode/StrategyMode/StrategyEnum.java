package DesignMode.StrategyMode;

import java.util.Arrays;

/**
 * @author Lucas
 * @date 2019/7/29 16:20
 * 当具体策略相对稳定时，推荐使用 策略枚举 简化代码
 */
public class StrategyEnum {
    public static void main(String[] args) {
        Calculator.ADD.cal(1,2);
    }

    static enum Calculator {
        ADD("+"){
            @Override
            void cal(int a, int b) {
                System.out.println(a + "+" + b + "=" + (a+b));
            }
        },
        SUB("-"){
            @Override
            void cal(int a, int b) {
                System.out.println(a + "-" + b + "=" + (a-b));
            }
        },
        MULTI("*"){
            @Override
            void cal(int a, int b) {
                System.out.println(a + "*" + b + "=" + (a*b));
            }
        },
        DIV("/"){
            @Override
            void cal(int a, int b) {
                System.out.println(a + "/" + b + "=" + (a/b));
            }
        };

        String desc;
        private Calculator(String desc){
            this.desc = desc;
        }
        String getDesc(){
            return desc;
        }
        abstract void cal(int a, int b);
    }
}
