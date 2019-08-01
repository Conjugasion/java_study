package Internet.NIOSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Lucas
 * @date 2019/8/1 14:34
 */
public class NIOChatClient {

    static Selector selector;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // 创建通道管理器(Selector)
        selector = Selector.open();

        // 创建通道SocketChannel
        SocketChannel channel = SocketChannel.open();
        // 将通道设置为非阻塞
        channel.configureBlocking(false);

        // 客户端连接服务器，其实方法执行并没有实现连接，需要在handleConnect方法中调channel.finishConnect()才能完成连接
        channel.connect(new InetSocketAddress("127.0.0.1", 6000));
        channel.register(selector, SelectionKey.OP_CONNECT);

        while (selector.select()>0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();

            }
        }
    }



}
