package Internet.BlOSocket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Lucas
 * @date 2019/7/30 16:28
 */
public class ChatClient1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 6000);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
        Scanner sc = new Scanner(System.in);

        //  发信息线程
        new Thread(){
            @Override
            public void run() {
                String message = null;
                while (true){
                    message = sc.nextLine();
                    if (message.equals("end")) break;
                    writer.println(message);
                    // writer.flush();
                }
            }
        }.start();

        // 收信息线程
        new Thread(){
            @Override
            public void run() {
                try{
                    String message;
                    while ((message = reader.readLine())!=null){
                        System.out.println(message);
                        //writer.println("server receive " + message);
                        //writer.flush();            // 手动刷新缓冲区
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
