package JDBC.jdbc.transaction_;

import JDBC.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("all")
public class Transaction_ {

    @Test
    public void noTransaction() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql1 = "update account set money = money - 100 where id = 100";
        String sql2 = "update account set money = money + 100 where id = 200";
        try {
            connection = JDBCUtils.getConnection();

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

//            int i = 1 / 0;

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void useTransaction(){
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql1 = "update account set money = money - 100 where id = 100";
        String sql2 = "update account set money = money + 100 where id = 200";
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();

//            int i = 1 / 0;

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();

            connection.commit();

        } catch (Exception e) {
            System.out.println("执行发生了异常，撤销执行的sql");
            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

}
