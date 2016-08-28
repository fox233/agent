package com.service;

import com.conf.Conf;
import com.zookeeper.ZookeeperOper;
import org.apache.zookeeper.KeeperException;

import java.util.List;

/**
 * Created by hadoop on 16-8-26.
 */
public class ZServer {

    private ZookeeperOper zookeeperOper;

    public void init(){
        zookeeperOper = new ZookeeperOper();
        zookeeperOper.createZookeeper();
        try {
            List<String> list = zookeeperOper.getChild(Conf.getWatch_update());

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
