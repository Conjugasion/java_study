package Commons_io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/13 21:18
 */
public class Demo2 {
    public static void main(String[] args) throws IOException {
        function4();
    }
    /**
     * readFileToString(File src) 读取文件
     */
    public static void function1() throws IOException {
        String s = FileUtils.readFileToString(new File("D:\\Tang\\java_exercise\\java_study\\main\\commons_io\\file\\readFileToString.txt"));
        System.out.println(s);
    }
    /**
     * writeStringToFile(File src, String date) 写文件
     */
    public static void function2() throws IOException {
        FileUtils.writeStringToFile(new File("D:\\Tang\\java_exercise\\java_study\\main\\commons_io\\file\\writeStringToFile.txt"),"阿道夫ZVB人民币弄破");
    }
    /**
     * copyFile(File src, File dest) 拷贝文件
     */
    public static void function3() throws IOException {
        FileUtils.copyFile(new File("D:\\Tang\\java_exercise\\java_study\\main\\commons_io\\file\\copy.txt"),new File("D:\\Tang\\java_exercise\\java_study\\main\\commons_io\\copy.txt"));
    }
    /**
     * copyDirectoryToDirectory 拷贝文件夹
     */
    public static void function4() throws IOException {
        FileUtils.copyDirectoryToDirectory(new File("D:\\Tang\\java_exercise\\java_study\\main\\commons_io\\file"),new File("D:\\Tang\\java_exercise\\java_study\\main"));
    }
}
