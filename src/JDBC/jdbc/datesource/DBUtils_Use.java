package JDBC.jdbc.datesource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("all")
public class DBUtils_Use {

    @Test
    public void testQueryMany() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "select * from actor where id >= ?";
        /**
         * (1) query 方法就是执行 sql 语句，得到 resultset ---封装到 --> ArrayList 集合中
         * (2) 返回集合
         * (3) connection: 连接
         * (4) sql : 执行的 sql 语句
         * (5) new BeanListHandler<>(Actor.class): 在将 resultset -> Actor 对象 -> 封装到 ArrayList
         *     底层使用反射机制 去获取 Actor 类的属性，然后进行封装
         * (6) 1 就是给 sql 语句中的? 赋值，可以有多个值，因为是可变参数 Object... params
         * (7) 底层得到的 resultset ,会在 query 关闭, 关闭 PreparedStatment
         * */
        List<Actor> list =
                queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class), 1);

        for (Actor actor : list) {
            System.out.println(actor);
        }

        JDBCUtilsByDruid.close(null, null, connection);

    }

    @Test
    public void testQuerySingle() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "select * from actor where id = ?";

        Actor actor = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class), 4);
        System.out.println(actor);

        JDBCUtilsByDruid.close(null, null, connection);

    }

    @Test
    public void testScalar() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

        String sql = "select name from actor where id = ?";

        Object obj = queryRunner.query(connection, sql, new ScalarHandler(), 2);
        System.out.println(obj);

        JDBCUtilsByDruid.close(null, null, connection);

    }

    @Test
    public void testDML() throws SQLException {
        Connection connection = JDBCUtilsByDruid.getConnection();
        QueryRunner queryRunner = new QueryRunner();

//        String sql = "update actor set name = ? where id = ?";
//        String sql = "insert into actor values (null,?,?,?,?)";
        String sql = "delete from actor where id = ?";

//        int affectedRow = queryRunner.update(connection, sql, "张三丰", 3);
//        int affectedRow = queryRunner.update(connection, sql, "林青霞", "女", "1966-10-10", "116");
        int affectedRow = queryRunner.update(connection, sql, 3);
        System.out.println(affectedRow > 0 ? "执行成功" : "执行没有影响到表");

        JDBCUtilsByDruid.close(null, null, connection);

    }

}
