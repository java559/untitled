package JDBC.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings("all")
public class PreparedStatement_ {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\JDBC\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入管理员名字: ");
        String admin_name = scanner.nextLine();
        System.out.print("请输入管理员密码: ");
        String admin_pwd = scanner.nextLine();

        String sql = "select name,pwd from admin where name = ? and pwd = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,admin_name);
        preparedStatement.setString(2,admin_pwd);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
