package IO;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/7 15:20
 * java.io.writer 所有字符输出流的超类
 * 只能写文本
 * write(int c), write(char[] c), write(char[] c, int,int) ,write(String s)
 * 必须flush
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\g.txt");
        fw.write(100);
        fw.flush();

        fw.write(new char[]{'a','b','c'});
        fw.flush();

        fw.write("\r\nnavigate");
        fw.flush();

        fw.close();
    }
}
