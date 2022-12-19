package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.nguoidungbean;
import bean.nhatdbean;

public class nhatddao {

  public ArrayList<nhatdbean> getntd() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<nhatdbean> ds = new ArrayList<nhatdbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from NhaTuyenDung";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long mantd = rs.getLong("MaNTD");
        String tenntd = rs.getString("TenNTD");
        String tendn = rs.getString("TenDN");
        String mk = rs.getString("MatKhau");
        String anh = rs.getString("Anh");
        ds.add(new nhatdbean(mantd, tenntd, tendn, mk, anh));
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

  public nhatdbean ktdnntd(String tendn, String pass) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<nhatdbean> ds = new ArrayList<nhatdbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from NhaTuyenDung where TenDN=? and MatKhau=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, tendn);
      cmd.setString(2, pass);
      ResultSet rs = cmd.executeQuery();
      nhatdbean ntd = null;
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long mantd = rs.getLong("MaNTD");
        String tenntd = rs.getString("TenNTD");
        String anh = rs.getString("Anh");
        ntd = new nhatdbean(mantd, tenntd, tendn, pass, anh);
      }
      // b4: dong ket noi
      rs.close();
      kn.cn.close();
      return ntd;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public int ThemNTD(String tendn, String pass, String ten) {
    try {
      // Tao 1 mang luu all loai
      String anh = "ntd-img/logo.jpg";
      ArrayList<nguoidungbean> ds = new ArrayList<nguoidungbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "insert into NhaTuyenDung(TenNTD, TenDN, MatKhau, Anh) values (?,?,?,?)";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, ten);
      cmd.setString(2, tendn);
      cmd.setString(3, pass);
      cmd.setString(4, anh);
      ResultSet rs = cmd.executeQuery();


      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }
}
