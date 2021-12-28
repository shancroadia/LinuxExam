package com.itheima.util;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String url;
    private static String username;
    private static String password;
    static {
        // src 下文件称为类路径，可以使用 ClassLoader 来进行读取
        InputStream is = null;
        try {
            is = JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties");
            // 1. 读取配置文件
            Properties p = new Properties();
            p.load(is);

            url = p.getProperty("jdbc.url");
            String driver = p.getProperty("jdbc.driver");
            username = p.getProperty("jdbc.username");
            password = p.getProperty("jdbc.password");

            // 2. 加载驱动
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException throwables) {
            // 1. return null
            // 2. 抛出一个运行时异常
            throw new RuntimeException(throwables);
        }
    }

    /**
     * 释放资源的方法
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 释放资源的方法
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
