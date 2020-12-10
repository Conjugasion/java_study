package NIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Lucas
 * @date 2019/4/22 20:15
 */
public class NioCopyFileDemo {
    public static void main(String[] args) throws IOException {
        func1();
    }
    private static void func1() throws IOException {
        // 获取输入输出流
        FileInputStream in = new FileInputStream("D:\\Tang\\java_exercise\\java_study\\main\\NIO\\file\\file1.txt");
        FileOutputStream out = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\NIO\\copyFile1.txt");
        // 获取通道
        FileChannel readChannel = in.getChannel();
        FileChannel writeChannel = out.getChannel();
        // 获取字节缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (true){
            buffer.clear();
            int len = readChannel.read(buffer);
            if(len == -1){
                break;
            }
            buffer.flip();
            writeChannel.write(buffer);
        }
        readChannel.close();
        writeChannel.close();
    }
}
