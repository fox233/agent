package com.service;

import com.conf.Conf;
import com.jedis.JedisOper;
import com.unit.JsonUnit;
import org.hyperic.sigar.*;

import java.util.UUID;

/**
 * Created by hadoop on 16-8-18.
 */
public class Monitor implements Runnable {
    public Monitor() {

    }

    public void init(){
        sigar = new Sigar();
        jedisOper = new JedisOper();
        jedisOper.setHostPort(Conf.getRedishost(),Conf.getRedisport());
        jedisOper.createJedisConn();
    }

    private Sigar sigar ;
    private JedisOper jedisOper;
    private boolean isRunMonitor=true;
    private int interval;

    public void setIsRun(boolean isRunMonitor) {
        this.isRunMonitor = isRunMonitor;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    @Override
    public void run() {
            while (isRunMonitor){

                String key = getkey();
                String value = getValue();

                jedisOper.set(key,value);

                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


    }

    private String getkey(){
        StringBuffer result=new StringBuffer();
        result.append(Conf.getHost());
        result.append("-");
        result.append(UUID.randomUUID());
        return result.toString();

    }

    private String getValue(){
        StringBuffer result=new StringBuffer();
        JsonUnit jsonUnit = new JsonUnit();

        try {
            Cpu cpu = sigar.getCpu();
            Mem mem = sigar.getMem();
            jsonUnit.add("MEM-Total",mem.getTotal());
            jsonUnit.add("MEM-Used",mem.getUsed());
            jsonUnit.add("MEM-Free",mem.getFree());

            CpuPerc cpuList[] = sigar.getCpuPercList();
            for (int i = 0; i < cpuList.length; i++) {
                jsonUnit.add("CPU-User-"+i,CpuPerc.format(cpuList[i].getUser()));
                jsonUnit.add("CPU-Sys-"+i,CpuPerc.format(cpuList[i].getSys()));
                jsonUnit.add("CPU-Wait-"+i,CpuPerc.format(cpuList[i].getWait()));
                jsonUnit.add("CPU-Nice-"+i,CpuPerc.format(cpuList[i].getNice()));
                jsonUnit.add("CPU-Idle-"+i,CpuPerc.format(cpuList[i].getIdle()));
                jsonUnit.add("CPU-Combined-"+i,CpuPerc.format(cpuList[i].getCombined()));
            }
        } catch (SigarException e) {
            e.printStackTrace();
        }
        result.append(jsonUnit.getJson());
        return result.toString();
    }


}
