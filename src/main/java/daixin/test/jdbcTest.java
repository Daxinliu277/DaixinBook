package daixin.test;

import daixin.utils.jdbcUtils;
import org.junit.Test;


import java.sql.Connection;
import java.sql.SQLException;

public class jdbcTest {

    @Test
    public void getConnections() throws SQLException {
        Connection connection = jdbcUtils.getConnection();
        System.out.println(connection);

    }
}
