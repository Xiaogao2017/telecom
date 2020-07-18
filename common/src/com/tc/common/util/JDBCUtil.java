package com.tc.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Mr. Li xiaogao 2020-06-01 22:21
 */
public class JDBCUtil {
    private static final String MYSQL_DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String MYSQL_URL = "jdbc:mysql://hadoop102:3306/telecom?useUnicode=true&characterEncoding=UTF-8";
    private static final String MYSQL_USERNAME = "root";
    private static final String MYSQL_PASSWORD = "root";
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(MYSQL_DRIVER_CLASS);
            connection = DriverManager.getConnection(MYSQL_URL,MYSQL_USERNAME,MYSQL_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
