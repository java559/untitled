package JDBC.jdbc.myjdbc;

public class TestJDBC {
    public static void main(String[] args) {
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();

        jdbcInterface = new OracleJdbcImpl();
        jdbcInterface.getConnection();
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
