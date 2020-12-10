package Internet.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @auther Lucas
 * @date 2019/1/15 10:16
 * 封装数据，接收数据java.net.DatagramPacket
 * 接收数据java.net.DatagramSocket
 */
public class UDPReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(6000);

        while (true){
            byte[] receiveData = new byte[1024];
            DatagramPacket dp = new DatagramPacket(receiveData,receiveData.length);
            ds.receive(dp);
            String ip = dp.getAddress().getHostAddress();
            int port = dp.getPort();
            int length = dp.getLength();
            System.out.println(new String(receiveData,0,length) + "..." + ip + ":" + port);
        }
    }
}
