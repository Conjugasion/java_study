package StringBulidAndStringBuffer;

/**
 * @auther Lucas
 * @date 2018/12/28 9:29
 * 运行速度StringBuild>StringBuffer>String
 * StringBuilder是线程不安全的，而StringBuffer是线程安全的
 * String：适用于少量的字符串操作的情况
 *StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
 *StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
 */
public class StringBuildDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder().append("abc");
        System.out.println(stringBuilder);
        String a = "hello2";
        String b = "hello";
        String c = b + 2;
        System.out.println((a == c));  // false

        String d = "hello2";
        final String e = "hello";
        String f = e + 2;
        System.out.println((d == f));

        String g =  new String("hello");
        String h =  new String("hello");
        String i = "hello";
        String j = g.intern();

        System.out.println(g==h);
        System.out.println(i==g);
        System.out.println(j==i);
        System.out.println(j==g);

        StringBuffer stringBuffer = new StringBuffer().append("def");
        System.out.println(stringBuffer);
    }
}
