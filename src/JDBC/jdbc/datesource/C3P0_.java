package JDBC.jdbc.datesource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

@SuppressWarnings("all")
public class C3P0_ {

    @Test
    public void testC3P0() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\JDBC\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");

        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        comboPooledDataSource.setInitialPoolSize(10);
        comboPooledDataSource.setMaxPoolSize(50);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
//            System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 500000次连接耗时=" + (end - start));

    }

    @Test
    public void testC3P0_02() throws Exception{
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hello");

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
//            System.out.println("连接成功~");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("c3p0 500000次连接耗时=" + (end - start));

    }

}
