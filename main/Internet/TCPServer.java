package Internet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @auther Lucas
 * @date 2019/1/15 14:43
 *  必须要获得客户端的套接字对象socket， Socket accept()
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        // 获取客户端套接字对象
        Socket client = server.accept();
        // 通过客户端套接字获取信息
        InputStream in = client.getInputStream();
        // 使用缓冲数组读取
        byte[] b1 = new byte[1024];
        int len = 0;
        while ((len = in.read(b1)) != -1){
            System.out.println(new String(b1,0,len));
        }

        OutputStream out = client.getOutputStream();
//        Scanner scanner = new Scanner(System.in);
//        String info = scanner.nextLine();
//        byte[] b2 = info.getBytes();
        out.write("你好客户端".getBytes());
        out.flush();

        client.close();
        server.close();

    }
}
