package JDBC.c01_flyway;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;

public class JDBCtest {
    public MariaDbDataSource createDBSource(String schema,String username, String password){
        String url="jdbc:mariadb://localhost:3306/"+schema+"?useUnicode=true";

        try{
            MariaDbDataSource dataSource = new MariaDbDataSource();
            dataSource.setUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Can not create data source", sqle);
        }
    }

    public static void main(String[] args) {
        JDBC.a03_fuggvenyekbeKiszervezve.JDBCtest jDBCtest=new JDBC.a03_fuggvenyekbeKiszervezve.JDBCtest();
        MariaDbDataSource dataSource=jDBCtest.createDBSource("employees","root","MariaDB1984");
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

    }


}
