package File;

import java.io.File;

/**
 * @auther Lucas
 * @date 2019/1/6 21:15
 * File构造器的三种重载形式
 */
public class fileConstructor {
    public static void main(String[] args) {
        function3();
    }

    /**
     * 将路径封装成File对象
     * File(String pathname)
     */
    public static void function1(){
        File file = new File("E:\\视频\\java基础班\\day22\\day22_video");
        System.out.println(file);
    }
    /**
     *File(String parent, String child)
     */
    public static void function2(){
        File file = new File("E:", "视频");
        System.out.println(file);
    }
    /**
     *File(File parent, String child)
     */
    public static void function3(){
        File parent = new File("E:");
        File file = new File(parent,"视频");
        System.out.println(file);
    }
}
