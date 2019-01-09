package IOtrans;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/8 21:25
 * 字节输入流的缓冲流
 * 继承InputStream，标准字节数入流
 *构造方法
 * BufferedInputStream(InputStream in)
 */
public class bufferInputStreamDemo {
    public static void main(String[] args)throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\Tang\\java_exercise\\java_study\\main\\IOtrans\\file\\bufferStream.txt"));
        byte[] b = new byte[3];
        int len = 0;
        while ((len = bis.read(b)) != -1){
            System.out.println(new String(b,0,len));
        }
        bis.close();
    }
}
