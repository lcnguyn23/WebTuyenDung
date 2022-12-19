package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.adminbean;

public class admindao {

  public adminbean ktdnadmin(String tendn, String pass) {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "select * from Admin where TenDN=? and MatKhau=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, tendn);
      cmd.setString(2, pass);
      ResultSet rs = cmd.executeQuery();
      adminbean dn = null;
      if (rs.next()) { // dang nhap thanh cong
        String TenDangNhap = rs.getString("TenDN");
        String MatKhau = rs.getString("MatKhau");
        int Quyen = rs.getInt("Quyen");
        dn = new adminbean(TenDangNhap, MatKhau, Quyen);
      }
      rs.close();
      kn.cn.close();
      return dn;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}
