package IOtrans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/9 20:23
 * 继承Reader
 *  读取字符/字符数组
 *  构造方法 BufferedReader(Reader r)，比如FileReader，InputStreamReader
 *  他有一个自己特有的方法String readLine() 读取文本行
 */
public class bufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Tang\\java_exercise\\java_study\\main\\IOtrans\\file\\buffered.txt"));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();

        String s1 = null;
        String s2 = "null";
        if("str" instanceof String){
            System.out.println("yes");
        }
    }
}
