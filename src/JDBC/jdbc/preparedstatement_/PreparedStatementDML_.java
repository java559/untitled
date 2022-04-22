package JDBC.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

@SuppressWarnings("all")
public class PreparedStatementDML_ {
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
//        System.out.print("请输入管理员密码: ");
//        String admin_pwd = scanner.nextLine();

//        String sql = "insert into admin values(?,?)";
//        String sql = "update admin set pwd = ? where name = ?";
        String sql = "delete from admin where name = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, admin_name);
//        preparedStatement.setString(2, admin_pwd);

        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "成功" : "失败");


        preparedStatement.close();
        connection.close();
    }
}
