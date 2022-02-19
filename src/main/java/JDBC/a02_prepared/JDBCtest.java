package JDBC.a02_prepared;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO diak (nev,naplo_id,taj) VALUES(?,?,?);");

                ){
            String name="Szép Virág";
            int naploID=2;
            String taj="987654321";
            stmt.setString(1, name);
            stmt.setInt(2, naploID);
            stmt.setString(3, taj);
            stmt.execute();
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Can not create data source", sqle);
        }


    }
}
