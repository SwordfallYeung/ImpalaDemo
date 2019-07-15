package com.impala.test;

import com.impala.model.Record;
import com.impala.util.ImpalaC3P0Util;
import java.util.List;

/**
 *  * @Author: Yang JianQiu
 *   * @Date: 2019/7/15 16:17
 *    */
public class Test {
    public static void main(String[] args) {
        String sql = "select imsi, uptime from imsi_record_by_hour order by uptime  limit 10 ";

        Record record = new Record();
        List<Record> list = ImpalaC3P0Util.queryList(Record.class, sql);

        for (Record record1: list){
            System.out.println(record1.getImsi() + "-" + record1.getUptime());
        }
    }
}
