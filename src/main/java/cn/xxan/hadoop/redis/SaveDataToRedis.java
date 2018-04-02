package cn.xxan.hadoop.redis;

import redis.clients.jedis.Jedis;

/**
 * redis 测试类
 */
public class SaveDataToRedis {

    public static void main(String[] args){
        Jedis jedis = new Jedis("192.168.4.130",6421);
        jedis.set("abcname","张三");

        System.out.println(jedis.get("abcname"));


    }
}
