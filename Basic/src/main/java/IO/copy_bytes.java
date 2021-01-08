package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @auther Lucas
 * @date 2019/1/7 14:33
 */
public class copy_bytes {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\file\\IO.avi");
            fos = new FileOutputStream("D:\\Tang\\java_exercise\\java_study\\main\\IO\\IO.avi");
            // 字节数组 提高效率
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = fis.read(b))!=-1){
                fos.write(b,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("文件复制失败");
        }finally {
            try {
                fos.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
