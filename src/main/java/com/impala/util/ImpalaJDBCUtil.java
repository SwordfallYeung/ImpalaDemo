package com.impala.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  * @Author: Yang JianQiu
 *   * @Date: 2019/6/11 16:12
 *    */
public class ImpalaJDBCUtil {

    private static String JDBC_DRIVER = "com.cloudera.impala.jdbc41.Driver";
    private static String CONNECTION_URL = "jdbc:impala://192.168.31.246:21050/meerkat";
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private static Connection getImpalaConnection(){
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = (Connection) DriverManager.getConnection(CONNECTION_URL);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
 *      * 返回Object对象
 *           * @param db
 *                * @param sql
 *                     * @return
 *                          */
    public static Object executeQuery(String db, String sql){

        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;

        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
        ArrayList<String> columns = new ArrayList<String>();

        try {
            Class.forName(JDBC_DRIVER);
            conn = getImpalaConnection();
            ps = conn.prepareStatement(sql);
            boolean flag = true;
            int columnsCount = 0;
            while (rs.next()){
                if (flag){
                    ResultSetMetaData metaData = rs.getMetaData();
                    columnsCount = metaData.getColumnCount();
                    for (int i = 1; i <= columnsCount; i++){
                        columns.add(metaData.getColumnLabel(i));
                    }
                    flag = false;
                }

                ArrayList<String> list = new ArrayList<>();
                for (int i = 1; i <= columnsCount; i++){
                    list.add(String.valueOf(rs.getObject(i)));
                }
                data.add(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs != null){
                    rs.close();
                }
                if (ps != null){
                    ps.close();
                }
                if (conn != null){
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return data;
    }

    public static <T> List<T> queryEntity(Class<T> entityClass, String sql, Object ... params){
        List<T> entityList = null;
        Connection conn = getImpalaConnection();
        if (conn == null) {
            return entityList;
        }

        try {
            entityList = QUERY_RUNNER.query(conn, sql, new BeanListHandler<>(entityClass), params);
        } catch (Exception e) {
            System.out.println("查询失败" + e.getMessage());
        } finally {
            closeConn(conn);
        }
        return entityList;
    }
    /**
 *      * 关闭连接
 *           * @param conn
 *                */
    public static void closeConn(Connection conn){
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
