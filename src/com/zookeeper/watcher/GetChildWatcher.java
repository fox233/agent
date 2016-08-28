package com.zookeeper.watcher;

import com.zookeeper.ZookeeperOper;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

/**
 * Created by hadoop on 16-8-19.
 */
public class GetChildWatcher implements Watcher {

    private ZookeeperOper zooKeeper;

    @Override
    public void process(WatchedEvent event) {


    }
}
