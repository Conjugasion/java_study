package JedisDemo;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Lucas
 * @date 2019/3/25 15:56
 */
public class jedispool {
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1",6379);
        Jedis jedis = jedisPool.getResource();
        String name = jedis.get("name");
        System.out.println(name);

        Map<String, String> h1 = jedis.hgetAll("h1");
        System.out.println(h1.toString());

        Boolean hexists = jedis.hexists("h1", "name");
        System.out.println(hexists);

        System.out.println(jedis.hlen("h1"));
        System.out.println(jedis.hkeys("h1").toString());

        List<String> l1 = new ArrayList<>();
        l1.add("1");
        l1.add("2");
        l1.add("3");
        l1.set(0,"123");
        System.out.println(l1.toString());

        jedis.close();
        jedisPool.close();
    }
}
