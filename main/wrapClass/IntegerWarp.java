package wrapClass;


/**
 * @auther Lucas
 * @date 2019/1/3 20:06
 */
public class IntegerWarp {
    public static void main(String[] args) {
        Integer a = Integer.valueOf("123");
        int b = Integer.parseInt("123");
        System.out.println(a==b);

        String c = Integer.toString(123);
        System.out.println(c);

        // Integer构造方法
        Integer i = new Integer(123);
        Integer j = new Integer("123");
        System.out.println(i==j);

        String d = String.valueOf(123);

    }
}
