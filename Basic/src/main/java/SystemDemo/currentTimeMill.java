package SystemDemo;

import java.util.Date;

/**
 * @auther Lucas
 * @date 2019/1/3 20:49
 */
public class currentTimeMill {
    public static void main(String[] args) {
        // 获取系统当前毫秒值
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
    }
}
