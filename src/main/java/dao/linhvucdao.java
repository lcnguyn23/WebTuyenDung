package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.linhvucbean;

public class linhvucdao {

  public ArrayList<linhvucbean> getlv() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<linhvucbean> ds = new ArrayList<linhvucbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from LinhVuc";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        String malv = rs.getString("MaLV");
        String tenlv = rs.getString("TenLV");
        ds.add(new linhvucbean(malv, tenlv));
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
