package JDBC.a03_fuggvenyekbeKiszervezve;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public static void insert(MariaDbDataSource dataSource) {
        try(Connection conn = dataSource.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO diak (nev,naplo_id,taj) VALUES(?,?,?);");
        ){
            String name="Szép Virág";
            int naploID=2;
            String taj="987654666";
            stmt.setString(1, name);
            stmt.setInt(2, naploID);
            stmt.setString(3, taj);
            stmt.execute();
        }
        catch (SQLException sqle) {
            throw new IllegalStateException("Can not create data source", sqle);
        }
    }
    public static void main(String[] args) {
        JDBCtest jDBCtest=new JDBCtest();
        MariaDbDataSource dataSource=jDBCtest.createDBSource("suli","root","MariaDB1984");
        insert(dataSource);
    }


}
