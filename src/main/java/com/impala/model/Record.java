package com.impala.model;

/**
 *  * @Author: Yang JianQiu
 *   * @Date: 2019/7/15 16:13
 *    */
public class Record {

    private String imsi;
    private Long uptime;

    public String getImsi() {
        return imsi;
    }

    public void setImsi(String imsi) {
        this.imsi = imsi;
    }

    public Long getUptime() {
        return uptime;
    }

    public void setUptime(Long uptime) {
        this.uptime = uptime;
    }
}
