package NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Lucas
 * @date 2019/4/22 21:15
 */
public class MappedByteBufferDemo {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("D:\\Tang\\java_exercise\\java_study\\main\\NIO\\file\\file2.txt", "rw");
        FileChannel channel = raf.getChannel();
        // 将文件映射到内存中
        MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, raf.length());
        mbb.put(0, (byte) 97);
        while (mbb.hasRemaining()){
            System.out.println((char) mbb.get());
        }
        raf.close();
    }
}
