package JDBC.jdbc;

import com.mysql.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@SuppressWarnings("all")
public class JdbcConn {

    @Test
    public void connect01() throws SQLException {
        Driver driver = new Driver();
        String url = "jdbc:mysql://localhost:3306/hsp_db03";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hsp");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect02() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hsp_db03";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "hsp");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    @Test
    public void connect03() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();

        String url = "jdbc:mysql://localhost:3306/hsp_db03";
        String user = "root";
        String password = "hsp";

        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection);
    }

    @Test
    public void connect04() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/hsp_db03";
        String user = "root";
        String password = "hsp";

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    @Test
    public void connect05() throws IOException, ClassNotFoundException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\JDBC\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\JDBC\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        Class.forName(driver);

        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "insert into actor values(null,'jack','男','1990-11-11','112')";
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "成功" : "失败");

        statement.close();
        connection.close();

    }

}
