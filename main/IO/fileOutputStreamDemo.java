package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/7 10:19
 * 字节输出流，创建文件
 * 若存在会覆盖
 */
public class fileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        function5();
    }

    /**
     * 直接写入字节
     * @throws IOException
     */
    public static void function1() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\a.txt");
        fos.write(100);
        fos.close();
    }

    /**
     * 写入字节数组
     * @throws IOException
     */
    public static void function2() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\b.txt");
        byte[] bytes = {65,66,67,68};
        fos.write(bytes);
        fos.close();
    }

    /**
     * 从指定位置写字节数组
     * @throws IOException
     */
    public static void function3() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\c.txt");
        byte[] bytes = {65,66,67,68};
        fos.write(bytes,1,2);
        fos.close();
    }

    /**
     * 将String类转成bytes
     * @throws IOException
     */
    public static void function4() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\d.txt");
        fos.write("String".getBytes());
        fos.close();
    }

    /**
     * 追加模式
     * @throws IOException
     */
    public static void function5() throws IOException {
        File file = new File("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\e.txt");
        FileOutputStream fos = new FileOutputStream(file,true);
        fos.write("\r\nhello".getBytes());
        fos.close();
    }
}
