package IOtrans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @auther Lucas
 * @date 2019/1/7 20:01
 *构造方法
 * inputStreamWriterDemo(InputStream in)
 * inputStreamWriterDemo(InputStream in,String charsetName)
 */
public class inputStreamReaderDemo {
    public static void main(String[] args) {
        try {
            function1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void function1() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\Tang\\java_exercise\\java_study\\main\\transIO\\file\\gbk.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gbk");
        char[] c = new char[1024];
        int len = 0;
        while ((len = isr.read(c))!=-1){
            System.out.println(new String(c,0,len));
        }
        isr.close();
    }
}
