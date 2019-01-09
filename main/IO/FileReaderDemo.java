package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/7 15:29
 * 只能读取字符，专门读取文本文件
 * int read() 读取一个字符
 * int read(char[] c) 读取字符数组
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        function2();
    }

    /**
     * read() 读取一个字符
     * @throws IOException
     */
    public static void function1() throws IOException {
        FileReader fr = new FileReader("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\f.txt");
        int content = 0;
        while ((content=fr.read())!=-1){
            System.out.println((char)content);
        }
        fr.close();
    }

    public static void function2() throws IOException {
        FileReader fr = new FileReader("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\f.txt");
        char[] b = new char[1024];
        int len = 0;
        while ((len=fr.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        fr.close();
    }
}
