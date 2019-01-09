package IOtrans;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/9 20:24
 * 构造方法
 * BufferedWriter(Writer w) ,能传递FileWriter，OutputStreamWriter
 * 它具有一个自己特有的方法 void newLine()
 */
public class bufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Tang\\java_exercise\\java_study\\main\\IOtrans\\file\\buffered.txt"));
        bw.write("100");
        // 写入行分隔符
        bw.newLine();

        bw.write("BufferedWriter");
        bw.newLine();

        bw.write("你好".toCharArray());
        bw.flush();
        bw.close();
    }

}
