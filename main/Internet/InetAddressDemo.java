package Internet;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @auther Lucas
 * @date 2019/1/15 9:30
 * java.net.InetAddress
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        function2();
    }

    /**
     * 获得自己的主机名和ip
     * @throws UnknownHostException
     */
    public static void function1() throws UnknownHostException {
        InetAddress inet = InetAddress.getLocalHost();
        System.out.println(inet.getClass());
        System.out.println(inet);
        String hostAddress = inet.getHostAddress();
        System.out.println(hostAddress);
    }
    /**
     * 获得别人的主机名和ip
     */
    public static void function2() throws UnknownHostException {
        InetAddress inet = InetAddress.getByName("www.baidu.com");
        System.out.println(inet.getClass());
        System.out.println(inet);
        String hostAddress = inet.getHostAddress();
        System.out.println(hostAddress);
        System.out.println(inet.getHostName());
    }
}
