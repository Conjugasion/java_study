package FileDemo;

import java.io.File;

/**
 * @auther Lucas
 * @date 2019/1/7 9:43
 * 遍历文件
 */
public class traversalDir {
    public static void main(String[] args) {
        traversal("D:\\Tang\\java_exercise\\java_study\\main\\File");
    }

    public static void traversal(String path){
        File file = new File(path);
        File[] listFiles = file.listFiles();
        // File[] listFiles = file.listFiles(new myFilter());
        for (File f : listFiles) {
            if (f.isFile()){
                System.out.println(f);
            }else {
                traversal(f.getAbsolutePath());
            }
        }
    }
}
