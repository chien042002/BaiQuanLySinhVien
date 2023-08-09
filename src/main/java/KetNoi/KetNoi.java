package KetNoi;

import oracle.jdbc.driver.OracleDriver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KetNoi {
    public static Connection GetConnection(){
          Connection c=null;
        try {
            DriverManager.registerDriver(new OracleDriver());
            String Url="jdbc:oracle:thin:@localhost:1521:ORCL21";
            String UserName="system";
            String Password="04102002";
             c=DriverManager.getConnection(Url,UserName,Password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }
    public static void CloseConnection(Connection c){
        if (c != null) {
            try {
                c.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void prinrtinfo(Connection c){
      if (c!=null){
          try {
              DatabaseMetaData mtdt=c.getMetaData();
              System.out.println(mtdt.getDatabaseProductName());
              System.out.println(mtdt.getDatabaseProductVersion());
          }
          catch (SQLException e){
                   throw new RuntimeException(e);
          }
      }
    }
}