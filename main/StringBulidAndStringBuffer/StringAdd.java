package StringBulidAndStringBuffer;

/**
 * @author Lucas
 * @date 2019/6/4 11:16
 * 字符串相加使用StringBuilder方法
 */
public class StringAdd {
    public static void main(String[] args) {
        String str = "hello,world!";
        String result = "";

        for (int i = 0; i < 100; i++) {
            result += str;
        }
    }

}
