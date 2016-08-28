package com.test;

import com.conf.Conf;
import com.zookeeper.ZookeeperOper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;

/**
 * Created by hadoop on 16-8-19.
 */
public class ZookeeperTest {

    public static void main(String[] args) {
        Conf conf = new Conf();
        ZookeeperOper zookeeperOper = new ZookeeperOper();
        zookeeperOper.createZookeeper();
        Stat stat= null;
        try {
            stat = zookeeperOper.exists("/abc");
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stat);
    }
}
