package JDBC.b02_selectList;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public static List<Diak> select(MariaDbDataSource dataSource) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("select id, nev, szuldatum, taj from diak where id <= ?");
        ) {
            int idLimit=3;
            stmt.setLong(1, idLimit);

            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                List<Diak> diakok=new ArrayList<>();
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("nev");
                    String szuldatum = rs.getString("szuldatum");
                    String taj = rs.getString("taj");
                    Diak diak=new Diak();
                    diak.setId(id);
                    diak.setName(name);
                    diak.setSzulIdo(szuldatum);
                    diak.setTaj(taj);
                    diakok.add(diak);
                }
                if(diakok.size()>0){
                    return diakok;
                }
                throw new IllegalArgumentException("No result");
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error by select", sqle);
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by select", sqle);
        }
    }
    public static void main(String[] args) {
        JDBC.a03_fuggvenyekbeKiszervezve.JDBCtest jDBCtest=new JDBC.a03_fuggvenyekbeKiszervezve.JDBCtest();
        MariaDbDataSource dataSource=jDBCtest.createDBSource("suli","root","MariaDB1984");
        List<Diak> diakok=select(dataSource);
        System.out.println(diakok);
    }


}
