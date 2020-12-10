package IOtrans;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/8 21:15
 * 继承自outputStream
 * write(int) write(byte[]) 写入字节
 * 缓冲流
 * BufferedOutputStream(OutputStream out)
 */
public class bufferOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\transIO\\file\\bufferStream.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(55);
        byte[] b= "helloworld".getBytes();
        bos.write(b);

        bos.flush();
        bos.close();

    }


}
