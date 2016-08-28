package com.jedis;

import com.conf.Conf;
import redis.clients.jedis.Jedis;

/**
 * Created by hadoop on 16-8-16.
 */
public class JedisOper   {

    private String host;
    private int port;
    private Jedis jedis;

    public JedisOper() {
//        this.host = Conf.getRedishost();
//        this.port = Conf.getRedisport();
//        createJedisConn();
    }

    public void setHostPort(String host,int port) {
        this.host = host;
        this.port = port;
    }


    public Jedis createJedisConn() {
        jedis = new Jedis(host, port);
        return jedis;
    }


    public void set(String key,String value) {
        String s = jedis.set(key,value);
    }


}
