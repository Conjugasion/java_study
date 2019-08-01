package Internet.BlOSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Lucas
 * @date 2019/7/30 16:28
 */
public class ChatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("server started!");
        ExecutorService pool = Executors.newFixedThreadPool(2);
        while (true){
            Socket socket = server.accept();
            pool.submit(new service(socket));    // 最多同时可以为两个client服务
            System.out.println("有新Client连进来");
        }
    }

    // 读取client发送的信息并返回ACK
    static class service implements Runnable{
        Socket socket;

        public service(Socket socket){
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
                String message;
                while ((message = reader.readLine())!=null){
                    System.out.println(message);
                    writer.println("I have received: " + message);
                    //writer.flush();            // 手动刷新缓冲区
                }
                // System.out.println("run end");    // 为什么跑不到这里？
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
