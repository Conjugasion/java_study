package transIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @auther Lucas
 * @date 2019/1/7 16:44
 * 字符文件
 * 将FileOutputStream字节流按指定码表写入文件
 * 继承writer类
 *构造方法 OutputStreamWriter(OutputStream out),OutputStreamWriter(OutputStream out,String charsetName),
 */
public class outputStreamWriterDemo {
    public static void main(String[] args){
        try {
            writeUTF();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeGBK() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\transIO\\file\\gbk.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
        osw.write("你好");
        osw.flush();
        osw.close();
    }

    public static void writeUTF() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\transIO\\file\\utf.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");
        osw.write("你好");
        osw.flush();
        osw.close();
    }
}
