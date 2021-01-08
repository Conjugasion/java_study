package Internet.BlOSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @auther Lucas
 * @date 2019/1/15 14:36
 * OutputStream getOutputStream()  将客户端数据输出到服务器
 * InputStream getInputStream() 客户端从服务器端读取数据
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6000);
        OutputStream out = socket.getOutputStream();
        out.write("你好服务器".getBytes());

        InputStream in = socket.getInputStream();
        byte[] b1 = new byte[1024];
        int len = 0;
        while ((len = in.read(b1)) != -1){
            System.out.println(new String(b1,0,len));
        }
        socket.close();
    }
}
