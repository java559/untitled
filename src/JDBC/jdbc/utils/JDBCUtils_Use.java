package JDBC.jdbc.utils;

import JDBC.dao_.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("all")
public class JDBCUtils_Use {

    @Test
    public void testDML() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "update admin set pwd = '333' where name = ?";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "hsp03");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select * from admin";
        try {
            connection = JDBCUtils.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String pwd = resultSet.getString("pwd");
                System.out.println(name + "\t" + pwd);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(resultSet, preparedStatement, connection);
        }
    }

    @Test
    public void testaaa(){
        QueryRunner qr = new QueryRunner();
        Connection connection = null;
        String sql = "select * from admin";
        try {

            connection = JDBCUtils.getConnection();
            List<Admin> king = qr.query(connection, sql, new BeanListHandler<Admin>(Admin.class));
            System.out.println(king);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

}
