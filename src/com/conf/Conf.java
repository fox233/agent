package com.conf;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by hadoop on 16-8-17.
 */
public class Conf {

    static String profilepath="/home/hadoop/agent/conf.properties";
    private static Properties props = new Properties();
    private HashMap<String,String> prop = new HashMap<>();
    private static String host;
    private static int port;
    private static String redishost;
    private static int redisport;
    private static String zookeeperhost;
    private static int zooSessionTimeout;
    private static String serviceId;
    private static String watch_update;

    public static String getServiceId() {
        return serviceId;
    }

    public static String getWatch_update() {
        return watch_update;
    }

    public static int getZooSessionTimeout() {
        return zooSessionTimeout;
    }



    public static String getHost() {
        return host;
    }

    public static int getPort() {
        return port;
    }

    public static String getRedishost() {
        return redishost;
    }

    public static int getRedisport() {
        return redisport;
    }

    public static String getZookeeperhost() {
        return zookeeperhost;
    }



    public  Conf() {
        try {
            props.load(new FileInputStream(profilepath));
            this.host = props.getProperty("host");
            if(props.getProperty("port")!=null){
                this.port = Integer.valueOf(props.getProperty("port"));
            }
            this.redishost = props.getProperty("redishost");
            if(props.getProperty("redisport")!=null){
                this.redisport = Integer.valueOf(props.getProperty("redisport"));
            }
            this.zookeeperhost = props.getProperty("zookeeperhost");
            if(props.getProperty("zooSessionTimeout")!=null){
                this.zooSessionTimeout = Integer.valueOf(props.getProperty("zooSessionTimeout"));
            }
            this.serviceId = props.getProperty("serviceId");
            this.watch_update = props.getProperty("watch_update");
        } catch (IOException e) {

            e.printStackTrace();
        }
    }


}
