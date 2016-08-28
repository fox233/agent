package com.zookeeper;

import com.zookeeper.watcher.ExistsWatcher;
import com.zookeeper.watcher.GetChildWatcher;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * Created by hadoop on 16-8-18.
 */
public class ZookeeperOper extends ZookeeperBasic{


    public ZookeeperOper() {
//        createZoo();
        Executors.newFixedThreadPool(3);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
    }
    public void createZookeeper(){
        createZoo();
    }
    public String create(String path, byte data[]) throws KeeperException, InterruptedException {
        String response = null;
        response=zooKeeper.create(path,data,null, CreateMode.EPHEMERAL);
        return  response;
    }

    public List<String> getChild(String path) throws KeeperException, InterruptedException {
        List<String> list = zooKeeper.getChildren(path,new GetChildWatcher() );
        return list;
    }

    public Stat exists(String path) throws KeeperException, InterruptedException {
        Stat stat = null;
            stat = zooKeeper.exists(path, new ExistsWatcher(this));
        return stat;

    }

    public void delete(String path) throws KeeperException, InterruptedException {
        zooKeeper.delete(path,-1);
    }
}
