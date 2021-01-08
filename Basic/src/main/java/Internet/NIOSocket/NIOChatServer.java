package Internet.NIOSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Lucas
 * @date 2019/8/1 14:34
 */
public class NIOChatServer {

    static Selector selector;
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(6000));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (selector.select()>0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isAcceptable()){
                    handleAccept(key);
                }else if (key.isConnectable()){
                    handleConnectable(key);
                }else if (key.isReadable()){
                    handleRead(key);
                }else if (key.isWritable()){
                    handleWrite(key);
                }
                iterator.remove();
            }
        }
    }

    // 处理客户端accept
    static void handleAccept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel =  (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("欢迎client连接".getBytes()));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }

    // 处理客户端Connection
    static void handleConnectable(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel =  (ServerSocketChannel) key.channel();
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("欢迎client连接".getBytes()));
        socketChannel.register(selector, SelectionKey.OP_READ);
    }

    // 处理客户端发送过来的消息
    static void handleRead(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        socketChannel.configureBlocking(false);
        // 从通道读取数据到缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(128);
        socketChannel.read(buffer);

        // 返回给客户端一个确认信息
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("我已收到：" + msg);
        socketChannel.register(selector, SelectionKey.OP_WRITE);
    }

    // 向客户端发送消息
    static void handleWrite(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        socketChannel.configureBlocking(false);
        String s = sc.nextLine();
        socketChannel.write(ByteBuffer.wrap(s.getBytes()));
        //socketChannel.register(selector, SelectionKey.OP_READ);
    }
}
