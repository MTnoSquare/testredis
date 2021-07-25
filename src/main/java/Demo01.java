import redis.clients.jedis.Jedis;

import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("192.168.122.10",6379);
        String pong=jedis.ping();
        System.out.println("连接成功"+pong);
        jedis.set("k0","v0");
        Set<String> keys=jedis.keys("*");
        System.out.println(keys.size());
        for(String key:keys){
            System.out.println(key);
        }
        System.out.println(jedis.exists("k1"));
        System.out.println(jedis.ttl("k1"));
        System.out.println(jedis.get("k1"));

        jedis.close();
    }
}
