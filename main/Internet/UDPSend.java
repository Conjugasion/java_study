package Internet;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @auther Lucas
 * @date 2019/1/15 10:00
 * 封装数据/接收方的地址和端口java.net.DatagramPacket
 *  public DatagramPacket(byte buf[], int offset, int length,InetAddress address, int port)
 * 传输数据java.net.DatagramSocket
 */
public class UDPSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        InetAddress inet = InetAddress.getByName("169.254.5.87");
        Scanner sc = new Scanner(System.in);
        while (true){
            String message = sc.nextLine();
            byte[] data = message.getBytes();

            DatagramPacket dp = new DatagramPacket(data, 0, data.length, inet, 6000);
            ds.send(dp);
        }
    }
}
