package Internet.ThreadUpload;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @auther Lucas
 * @date 2019/1/15 16:18
 */
public class TCPThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        int i = 1;
        while (true){
            // 获取一个客户端socket，就开启一个新线程
            Socket socket = server.accept();
            new Thread(new download(socket, "D:\\Tang\\java_exercise\\java_study\\main\\Internet\\zoro" + i +".jpg")).start();
            i++;
        }


    }
}
