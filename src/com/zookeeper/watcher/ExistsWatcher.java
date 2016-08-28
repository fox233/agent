package com.zookeeper.watcher;

import com.zookeeper.ZookeeperOper;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by hadoop on 16-8-19.
 */
public class ExistsWatcher implements Watcher {

    private ZookeeperOper zooKeeper;

    public ExistsWatcher(ZookeeperOper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }


    @Override
    public void process(WatchedEvent event) {
        System.out.println(event);
        zooKeeper.exists(event.getPath());
    }
}
