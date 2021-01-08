package FileDemo;

import java.io.File;

/**
 * @auther Lucas
 * @date 2019/1/6 22:14
 */
public class judgeIsOrNotExist {
    public static void main(String[] args) {
        function2();
    }

    /**
     * 文件/文件夹是否存在
     */
    public static void function1(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File");
        boolean b = file.exists();
        System.out.println(b);
    }

    /**
     * 是不是文件夹
     */
    public static void function2(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File\\fileAcquireInfo.java");
        boolean b = file.isDirectory();
        System.out.println(b);
    }
}
