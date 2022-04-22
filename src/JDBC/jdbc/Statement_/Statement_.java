package JDBC.jdbc.Statement_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings("all")
public class Statement_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\JDBC\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入管理员名字: ");
        String admin_name = scanner.nextLine();
        System.out.print("请输入管理员密码: ");
        String admin_pwd = scanner.nextLine();

        /*
        * SQL注入
        * 用户名 1' or
        * 密码  or '1' = '1
        */

        String sql = "select name,pwd from admin where name='"
                + admin_name + "' and pwd='" + admin_pwd + "'";
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
