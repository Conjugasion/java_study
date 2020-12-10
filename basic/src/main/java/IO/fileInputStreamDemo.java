package IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StreamCorruptedException;

/**
 * @auther Lucas
 * @date 2019/1/7 10:59
 * 字节输入流
 * read，每次读取1个字节
 * 读完返回-1
 * 读取中文会乱码，需要用FileReader
 */
public class fileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        function2();
    }

    /**
     * read单个读取
     * @throws IOException
     */
    public static void function1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\e.txt");
        int content = 0;
        while ((content=fis.read())!=-1){
            System.out.println((char)content);
        }
        fis.close();
    }

    /**
     * read(byte[] b) 读取字节数组
     * @throws IOException
     */
    public static void function2() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\e.txt");
        byte[] b = new byte[3];
        int len = 0;
        while ((len = fis.read(b))!=-1){
            // System.out.println(len);
            System.out.println(new String(b,0,len));
        }
        fis.close();
    }
}
