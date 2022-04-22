package JDBC.jdbc.datesource;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("all")
public class JDBCUtilsByDruid_Use {

    @Test
    public void testDML() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "update admin set pwd = 444 where name = ?";
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "hsp03");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, preparedStatement, connection);
        }

    }

    @Test
    public void testSelect() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String sql = "select * from admin";
        try {
            connection = JDBCUtilsByDruid.getConnection();
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
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
    }

    @Test
    public ArrayList<Actor> testSelectToArrayList() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Actor> list = new ArrayList<Actor>();

        String sql = "select * from actor";
        try {
            connection = JDBCUtilsByDruid.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                Date borndate = resultSet.getDate("borndate");
                String phone = resultSet.getString("phone");

                list.add(new Actor(id, name, sex, borndate, phone));
            }
//            System.out.println(list);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(resultSet, preparedStatement, connection);
        }
        return list;
    }
}
