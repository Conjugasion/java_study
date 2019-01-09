package FileDemo;

import java.io.File;

/**
 * @auther Lucas
 * @date 2019/1/6 21:43
 */
public class fileAcquireInfo {
    public static void main(String[] args) {
        function1();
    }

    /**
     * 获取路径的最后一部分
     */
    public static void function1(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File\\fileAcquireInfo.java");
        String name = file.getName();
        System.out.println(name);
    }

    /**
     * 获取文件大小，字节数
     */
    public static void function2(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File\\fileAcquireInfo.java");
        long length = file.length();
        System.out.println(length);
    }

    /**
     * 获取文件的绝对路径
     */
    public static void function3(){
        File file = new File("File.fileAcquireInfo");
        File absolutePath = file.getAbsoluteFile();
        System.out.println(absolutePath);
    }

    /**
     *
     */
    public static void function4(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File\\fileAcquireInfo.java");
        File parent = file.getParentFile();
        System.out.println(parent);
    }
}
