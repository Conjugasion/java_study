package IO;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/7 15:54
 */
public class copy_chars {
    public static void main(String[] args) {
        try {
            function2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拷贝字符文件
     * @throws IOException
     */
    public static void function1() throws IOException {
        FileReader fr = new FileReader("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\big.txt");
        FileWriter fw = new FileWriter("D:\\Tang\\java_exercise\\java_study\\main\\IO\\big.txt");
        char[] c = new char[1024];
        int len = 0;
        while ((len = fr.read(c))!=-1){
            fw.write(c,0,len);
            fw.flush();
        }
        fw.close();
        fr.close();
    }

    /**
     * 拷贝图片
     * @throws IOException
     */
    public static void function2() throws IOException {
        FileImageInputStream ii = new FileImageInputStream(new File("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\zoro.jpg"));
        FileImageOutputStream io = new FileImageOutputStream(new File("D:\\Tang\\java_exercise\\java_study\\main\\IO\\zoro.jpg"));
        byte[] b = new byte[1024];
        int len = 0;
        while ((len= ii.read(b))!=-1){
            io.write(b,0,len);
            io.flush();
        }
        io.close();
        ii.close();
    }

}
