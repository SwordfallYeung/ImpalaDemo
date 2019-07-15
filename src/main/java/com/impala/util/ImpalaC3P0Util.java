package com.impala.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *  * @ClassName: ImpalaC3P0Util
 *   * @Description: TODO
 *    * @Author TanXiongZhan
 *     * @Date 2019/7/1
 *      */
public class ImpalaC3P0Util {

    private static DataSource ds;
    private static QueryRunner queryRunner;

    static {
        ds = new ComboPooledDataSource();
        queryRunner = new QueryRunner(ImpalaC3P0Util.getDatasSource());
    }

    public static DataSource getDatasSource() {
        return ds;
    }

    public static Connection getConn() {
        Connection con = null;
        try {
            con = ds.getConnection();//每一次从ds中获取一个新的连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void update(String sql) {
        try {
            queryRunner.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static <T> List<T> queryList(Class<T> entityClass, String sql, Object... params) {

        List<T> list = null;
        try {
            list = queryRunner.query(sql, new BeanListHandler<T>(entityClass), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
