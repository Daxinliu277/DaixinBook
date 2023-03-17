package daixin.dao.impl;

import daixin.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private static QueryRunner qr = new QueryRunner();

    public static int update(String sql, Object... a) {//增 删 改
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            return qr.update(conn, sql, a);
        } catch (SQLException e) {
            throw new RuntimeException(e);//抛出异常以让其他类知道 报错
        }

    }

    public <T> T queryforOne(Class<T> type, String sql, Object... a) {//返回单条数据查询
        Connection connection = null;
        try {
            connection = jdbcUtils.getConnection();
            return (T) qr.query(connection, sql, new BeanHandler<>(type), a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> queryforList(Class<T> type, String sql, Object... a) {//返回多条数据查询
        Connection connection = null;
        try {
            connection = jdbcUtils.getConnection();
            return (List<T>) qr.query(connection, sql, new BeanListHandler<>(type), a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object queryforValue(String sql, Object... a)  {
        Connection connection = null;
        try {
            connection = jdbcUtils.getConnection();
            return qr.query(connection, sql, new ScalarHandler(), a);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
