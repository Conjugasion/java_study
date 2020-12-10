package ExceptionDemo.user_defined;

import ExceptionDemo.ExceptionDemo;

import java.text.DecimalFormat;

/**
 * @auther Lucas
 * @date 2019/1/6 16:42
 */
public class user_defined_Exception {
    public static void main(String[] args) {

        String avg = getAvg(10, 20, -10, -20);
        System.out.println(avg);
    }

    public static String  getAvg(int...grades) {
        double sum = 0;
        for (int g : grades){
            if (g < 0){
                // 自定义异常
                throw new myException("成绩错误"+ g);
            }
            sum = sum + g;
        }
        DecimalFormat df = new DecimalFormat(".0");
        return df.format(sum/grades.length);
    }
}
