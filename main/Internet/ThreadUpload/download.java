package Internet.ThreadUpload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @auther Lucas
 * @date 2019/1/15 16:15
 */
public class download implements Runnable{

    private Socket socket;
    private String path;

    public download(Socket socket, String path) {
        this.socket = socket;
        this.path = path;
    }

    @Override
    public void run() {
        try{
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
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
