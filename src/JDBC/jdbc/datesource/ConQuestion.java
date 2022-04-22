package JDBC.jdbc.datesource;

import JDBC.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConQuestion {

    @Test
    public void testCon() {
        long start = System.currentTimeMillis();
        System.out.println("开始连接");
        for (int i = 0; i < 5000; i++) {
            Connection connection = JDBCUtils.getConnection();
            //......
            JDBCUtils.close(null,null,connection);
        }
        long end = System.currentTimeMillis();

        System.out.println("传统方式耗时=" + (end - start));
    }
}
