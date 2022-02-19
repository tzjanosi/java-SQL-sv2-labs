package JDBC.a01_testConnection;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCtest {
    public static void main(String[] args) {
        String url="jdbc:mariadb://localhost:3306/suli?useUnicode=true";
        String username="root";
        String password="MariaDB1984";
        MariaDbDataSource dataSource;
        try{
            dataSource = new MariaDbDataSource();
            dataSource.setUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
        }
        catch (SQLException sqle) {
                throw new IllegalStateException("Can not create data source", sqle);
            }
        try(
        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement()){
            stmt.executeUpdate("INSERT INTO diak (nev,naplo_id,taj) VALUES('Fehér Virág',1,'123456789');");
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Can not create data source", sqle);
        }


    }
}
