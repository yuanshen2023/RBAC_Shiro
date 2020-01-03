package github.mrapee.rbac;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @program: rbac_shiro
 * @description: 测试Jedis连接Redis
 * @author: yuan_shen
 * @create: 2020-01-03 13:40
 **/

public class JedisTest {
    public static void main(String[] args){
        Jedis jedis = new Jedis("localhost");
        System.err.println("连接成功");
        jedis.set("runoobkey","rbac_shiro");
        jedis.lpush("site","baidu");
        jedis.lpush("site","google");
        jedis.lpush("site","taobao");
        List<String> list = jedis.lrange("site",0,2);
        list.forEach(site-> System.err.println("列表项为："+site));

        Set<String> keys = jedis.keys("*");
        keys.forEach(key->System.err.println("key为："+ key));
        System.err.println("redis存储得字符串为："+jedis.get("runoobkey"));
    }

}
