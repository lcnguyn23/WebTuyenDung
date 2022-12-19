package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.hinhthucbean;

public class hinhthucdao {

  public ArrayList<hinhthucbean> getht() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<hinhthucbean> ds = new ArrayList<hinhthucbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from VHT order by HinhThuc desc";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        String maht = rs.getString("MaHT");
        String tenht = rs.getString("TenHT");
        String ht = rs.getString("HinhThuc");
        ds.add(new hinhthucbean(maht, tenht, ht));
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
