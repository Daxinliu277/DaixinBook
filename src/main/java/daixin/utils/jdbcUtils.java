package daixin.utils;


import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class jdbcUtils {
    private static DataSource source;
    public static ThreadLocal<Connection> conns =new ThreadLocal<Connection>();

    static {

        try {
            Properties prps = new Properties();
//            ClassLoader.getSystemClassLoader().getResourceAsStream() 这个方法他不可以获取
            InputStream is = jdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");//需要这样去使用 不能使用System去获取这个Resource
            prps.load(is);
            Class.forName("com.mysql.jdbc.Driver");
            source = DruidDataSourceFactory.createDataSource(prps);
            if (is != null) {
                is.close();

            }
        } catch (Exception e) {
            System.out.println(e.fillInStackTrace());
        }

    }

    public static Connection getConnection()  {
        Connection conn = conns.get();

        try {
            if(conn==null){
                conn= source.getConnection();;
                conns.set(conn);
                conn.setAutoCommit(false);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

    public static void CloseAndCommit()  {
        Connection conn= conns.get();
        if(conn!=null){
            try {
                conn.commit();
            } catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        conns.remove();
    }
    public static void CloseAndRollback()  {
        Connection conn= conns.get();
        if(conn!=null){
            try {
                conn.rollback();
            } catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        conns.remove();
    }

    public static Connection getConnection2() throws Exception {
        InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("src/jdbc.properties");

        Properties properties = new Properties();

        properties.load(resourceAsStream);

        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String drivername = properties.getProperty("drivername");
        String user = properties.getProperty("user");

        Class.forName(drivername);

        Connection connection = DriverManager.getConnection(url, user, password);

        return connection;
    }

//    public static void CloseSource(Connection connection) {
//        DbUtils.closeQuietly(connection);
//    }
//
//    public static void CloseSource(Connection connection, PreparedStatement ps) {
//        DbUtils.closeQuietly(connection);
//        DbUtils.closeQuietly(ps);
//
//    }
//
//    public static void CloseSource(Connection connection, PreparedStatement ps, ResultSet rs) {
//        DbUtils.closeQuietly(connection);
//        DbUtils.closeQuietly(ps);
//        DbUtils.closeQuietly(rs);
//    }


}
