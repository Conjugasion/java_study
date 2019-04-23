package JedisDemo;

import redis.clients.jedis.Jedis;

/**
 * @author Lucas
 * @date 2019/3/25 15:37
 */
public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }
}
