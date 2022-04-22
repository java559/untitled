package JDBC.jdbc.datesource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

@SuppressWarnings("all")
public class Druid_ {

    @Test
    public void testDruid() throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection connection = dataSource.getConnection();
//            System.out.println("连接成功");
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("druid 500000次连接耗时=" + (end - start));

    }

}
