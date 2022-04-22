package JDBC.jdbc.batch_;

import JDBC.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;


@SuppressWarnings("all")
public class Batch_ {
    @Test
    public void noBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into admin2 values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();

        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.executeUpdate();
        }

        long end = System.currentTimeMillis();
        System.out.println("传统方式耗时=" + (end - start));

        JDBCUtils.close(null, preparedStatement, connection);
    }

    @Test
    public void useBatch() throws Exception {
        Connection connection = JDBCUtils.getConnection();

        String sql = "insert into admin2 values (null,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println("开始执行");
        long start = System.currentTimeMillis();

        for (int i = 0; i < 5000; i++) {
            preparedStatement.setString(1, "jack" + i);
            preparedStatement.setString(2, "666");
            preparedStatement.addBatch();
            if ((i + 1) % 1000 == 0){
                preparedStatement.executeBatch();
                preparedStatement.clearBatch();
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("批处理方式耗时=" + (end - start));

        JDBCUtils.close(null, preparedStatement, connection);
    }

}
