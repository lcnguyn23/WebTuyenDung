package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
  public Connection cn;

  public void KetNoi() {
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      System.out.println("Xong b1");
      String st = "jdbc:sqlserver://TANLOC:1433;databaseName=WebTuyenDung;user=sa2; password=123";
      cn = DriverManager.getConnection(st);
      System.out.println("Xong b2");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    KetNoi kn = new KetNoi();
    kn.KetNoi();
  }

}
