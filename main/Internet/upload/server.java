package Internet.upload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther Lucas
 * @date 2019/1/15 15:20
 */
public class server {
    public static void main(String[] args) throws IOException {
        download("D:\\Tang\\java_exercise\\java_study\\main\\Internet\\zoro1.jpg");
    }

    /**
     * 下载
     */
    public static void download(String path) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        Socket socket = server.accept();

        InputStream in = socket.getInputStream();
        FileOutputStream image = new FileOutputStream(path);
        byte[] b = new byte[1024];
        int len = 0;
        // 此处read线程等待，因为读不到-1
        while ((len = in.read(b)) != -1){
            image.write(b,0,len);
            // image.flush();
        }

        OutputStream out = socket.getOutputStream();
        out.write("已收到".getBytes());


        image.close();
        socket.close();
        server.close();

    }
}
