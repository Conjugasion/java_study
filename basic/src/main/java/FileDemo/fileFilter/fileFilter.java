package FileDemo.fileFilter;

import java.io.File;

/**
 * @auther Lucas
 * @date 2019/1/6 22:25
 */
public class fileFilter {
    public static void main(String[] args) {
        function1();
    }

    /**
     * 筛选文件
     */
    public static void function1(){
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\File");
        File[] listFiles = file.listFiles(new myFilter());
        for (File f : listFiles) {
            System.out.println(f);
        }
    }
}
