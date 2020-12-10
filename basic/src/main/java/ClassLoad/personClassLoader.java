package ClassLoad;

import java.net.URL;

/**
 * @auther Lucas
 * @date 2019/1/24 22:24
 */
public class personClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        Class p = Class.forName("ClassLoad.person");

        // 字节码对象.getClassLoader()
        ClassLoader loader = p.getClassLoader();
        ClassLoader loader1 = new person().getClass().getClassLoader();

        System.out.println(loader);
        System.out.println(loader==loader1);

        // 获得classes下的任何资源路径
        URL url = loader.getResource("ClassLoad/person.class");
        System.out.println(url);


    }
}
