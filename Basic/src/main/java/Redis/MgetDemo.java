package Redis;

import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author tangdongfan
 * @date 2020/6/3 20:17
 */
public class MgetDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        List<String> mget = jedis.mget("name", "age", "address");
        System.out.println(mget);
        jedis.close();
    }
}
