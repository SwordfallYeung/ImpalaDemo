package com.impala.test;

import com.impala.model.ImsiRecord;
import com.impala.util.ImpalaC3P0Util;
import org.apache.commons.lang.StringUtils;
import java.util.List;

/**
 *  * @Author: Yang JianQiu
 *   * @Date: 2019/6/24 17:37
 *    */
public class ImpalaTest {

    public static void main(String[] args) {

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" select createtime, deviceid, imsi, nettype, placeid, placename, regional, uptime from imsi_record_by_hour ");
        /**
 *          * String sql = "select imsi, deviceId from imsi_record_by_hour order by uptime  limit 100 ";
 *                   */

        ImsiRecord imsiRecordCondition = new ImsiRecord();

        StringBuffer condition = new StringBuffer();
        condition.append(" where ");
        boolean flag = false;

        if (StringUtils.isNotEmpty(imsiRecordCondition.getImsi())) {
            if (imsiRecordCondition.getImsi().trim().length() == 15) {
                condition.append(" imsi = '" + imsiRecordCondition.getImsi().trim() + "' and ");
            } else {
                condition.append(" imsi like '%" + imsiRecordCondition.getImsi().trim() + "%' and ");
            }
            flag = true;
        }

        if (StringUtils.isNotEmpty(imsiRecordCondition.getRegional())) {
            condition.append(" regional like '%" + imsiRecordCondition.getRegional() + "%' and " );
            flag = true;
        }

        if (StringUtils.isNotEmpty(imsiRecordCondition.getDeviceId())){
            condition.append(" deviceid = '" + imsiRecordCondition.getDeviceId() + "' and ");
            flag = true;
        }

        String sql = "";
        String orderByLimit = " order by uptime limit 10 ";
        int lastAndIndex = condition.lastIndexOf("and");

        if (flag){
            sql = stringBuffer.toString() +  condition.substring(0, lastAndIndex) + orderByLimit;
        }else {
            sql = stringBuffer.toString() + orderByLimit;
        }

        System.out.println(sql);
        List<ImsiRecord> list = ImpalaC3P0Util.queryList(ImsiRecord.class, sql);

        for (ImsiRecord imsiRecord: list){
            System.out.println(imsiRecord.getImsi() + "-" + imsiRecord.getDeviceId());
        }
    }
}
