package commons_io;

import org.apache.commons.io.FilenameUtils;

/**
 * @auther Lucas
 * @date 2019/1/13 20:02
 */
public class Demo1 {
    public static void main(String[] args) {
        FilenameUtils fis = null;
        function3();
    }

    /**
     * FilenameUtils类的方法
     * 获得扩展名
     */
    public static void function1(){
        String name = FilenameUtils.getExtension("abc.java");
        System.out.println(name);
    }

    /**
     *获取路径文件名
     */
    public static void function2(){
        String name = FilenameUtils.getName("c://abc.java");
        System.out.println(name);
    }
    /**
     *
     */
    public static void function3(){
        boolean b = FilenameUtils.isExtension("abc.java","java");
        System.out.println(b);
    }
}
