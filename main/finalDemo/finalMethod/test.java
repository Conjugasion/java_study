package finalDemo.finalMethod;

/**
 * @auther Lucas
 * @date 2018/12/28 15:15
 */
public class test {
    public static void main(String[] args) {
        father s = new son();
        System.out.println(s.getClass());
        s.show();
        // s.run();

        final String a = "a";
        //i = 20;
        String b = "ab";
        String c = a + "b";
        System.out.println(b==c);

        System.out.println("************");
        System.out.println("==比较的是内存地址是否相同");
        String d = "a";
        //i = 20;
        String e = "ab";
        String f = d + "b";
        System.out.println(e==f);

        System.out.println("************");
        System.out.println("equals比较的是内容");
        String g = "a";
        //i = 20;
        String h = "ab";
        String i = d + "b";
        System.out.println(h.equals(i));

    }
}
