package PropertiesDemo;

import java.io.*;
import java.util.Iterator;
import java.util.Properties;

/**
 * @auther Lucas
 * @date 2019/1/9 21:48
 * 继承hashtabkle，实现map接口
 * 和IO对象结合使用，实现数据的持久存储
 */
public class propertiesDemo {
    public static void main(String[] args) throws IOException {
        function3();
    }
    /**
     * 存储键值对setProperty(String,String)
     * getProperty(String key)
     */
    public static void function1(){
        Properties pro = new Properties();
        pro.setProperty("a","1");
        pro.setProperty("b","2");
        pro.setProperty("c","3");

        Iterator it = pro.keySet().iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        System.out.println(pro.getProperty("a"));
        System.out.println(pro.getProperty("d"));
    }
    /**
     * 特有方法load(InputStream in),load(Reader)
     * 流对象读取文件中的键值对，保存到集合
     */
    public static void function2() throws IOException {
        Properties pro = new Properties();
        FileReader fr = new FileReader(new File("D:\\Tang\\java_exercise\\java_study\\main\\PropertiesDemo\\file\\load.properties"));
        //调用properties的方法load，传递字符输入流
        pro.load(fr);
        fr.close();
        System.out.println(pro);
    }
    /**
     * 特有方法store(OutputStream out),store(Writer w)
     * 接受所有字节/字符的输出流，将集合中的键值对写回文件
     */
    public static void function3() throws IOException {
        Properties pro = new Properties();
        pro.setProperty("name","张三");
        pro.setProperty("age","30");
        pro.setProperty("email","网易邮箱");
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\PropertiesDemo\\file\\store1.properties");
        pro.store(fos,"评论");
        fos.close();

        FileWriter fw = new FileWriter("D:\\Tang\\java_exercise\\java_study\\main\\PropertiesDemo\\file\\store2.properties");
        pro.store(fw,"评论");
        fw.close();
    }
}
