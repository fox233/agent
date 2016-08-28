package com.service;

import com.conf.Conf;

/**
 * Created by hadoop on 16-8-19.
 */
public class Service {
    private String serviceId;
    private Monitor monitor;

    public void init(){
        Conf conf = new Conf();
        monitor = new Monitor();
        monitor.init();
        monitor.setInterval(10000);
        monitor.setIsRun(true);

    }

    public void startMonitor(){
        new Thread(monitor).start();
    }

    public static void main(String[] args) {
        Service service = new Service();
        service.init();
        service.startMonitor();
    }
}
