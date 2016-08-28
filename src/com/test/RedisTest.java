package com.test;

import com.conf.Conf;
import com.jedis.JedisOper;

/**
 * Created by hadoop on 16-8-23.
 */
public class RedisTest {
    public static void main(String[] args) {
        Conf conf = new Conf();
        JedisOper jedisOper = new JedisOper();
        jedisOper.setHostPort(Conf.getRedishost(),Conf.getRedisport());
        jedisOper.createJedisConn();
        jedisOper.set("redistest","bbb");

    }
}
