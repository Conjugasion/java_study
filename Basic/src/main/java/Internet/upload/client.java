package Internet.upload;


import java.io.*;
import java.net.Socket;

/**
 * @auther Lucas
 * @date 2019/1/15 15:20
 */
public class client {
    public static void main(String[] args) throws IOException {
        upload("D:\\Tang\\java_exercise\\java_study\\main\\Internet\\zoro.jpg");
    }
    /**
     * 上传
     */
    public static void upload(String path) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6000);
        OutputStream out = socket.getOutputStream();

        FileInputStream image = new FileInputStream(path);
        byte[] b = new byte[1024];
        int len = 0 ;
        while ((len = image.read(b)) != -1){
            out.write(b,0,len);
            // out.flush();
        }

        //给服务器写终止序列
        socket.shutdownOutput();


        // 获取上传成功返回的信息
        InputStream in = socket.getInputStream();
        // !!! 此处有线程等待
        // 如果因为已经到达流末尾而没有可用的字节，则返回值 -1。在输入数据可用、检测到流末尾或者抛出异常前，此方法一直阻塞。
        len = in.read(b);
        System.out.println(new String(b,0,len));


        image.close();
        socket.close();

    }
}
