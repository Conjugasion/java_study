package File;

import java.io.File;

/**
 * @auther Lucas
 * @date 2019/1/6 22:19
 */
public class fileList {
    public static void main(String[] args) {
        function2();
    }

    /**
     * String[] strs = file.list()
     * 获取路径下的文件和文件夹String[]
     */
    public static void function1(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File");
        String[] list = file.list();
        for (String i : list){
            System.out.println(i);
        }
    }

    /**
     * String[] strs = file.list()
     * 获取路径下的文件和文件夹File[]
     */
    public static void function2(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File");
        File[] listFiles = file.listFiles();
        for (File i : listFiles){
            System.out.println(i);
        }
    }
}
