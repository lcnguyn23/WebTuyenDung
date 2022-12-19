package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.topctybean;

public class topctydao {

  public ArrayList<topctybean> gettopntd() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<topctybean> ds = new ArrayList<topctybean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select t.TenNTD, t.SoViec, nt.Anh\r\n" + "from VTOPTD as t\r\n"
          + "    join NhaTuyenDung as nt on t.TenNTD = nt.TenNTD";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        String tenntd = rs.getString("TenNTD");
        long soviec = rs.getLong("SoViec");
        String anh = rs.getString("Anh");
        ds.add(new topctybean(tenntd, soviec, anh));
      }
      // b4: dong ket noi
      rs.close();
      kn.cn.close();
      return ds;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
