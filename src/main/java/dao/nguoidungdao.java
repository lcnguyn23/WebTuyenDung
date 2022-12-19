package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.nguoidungbean;

public class nguoidungdao {

  public ArrayList<nguoidungbean> getnd() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<nguoidungbean> ds = new ArrayList<nguoidungbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from NguoiDung";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long mand = rs.getLong("MaND");
        String hoten = rs.getString("HoTen");
        String diachi = rs.getString("DiaChi");
        String sodt = rs.getString("SoDT");
        String email = rs.getString("Email");
        String tendn = rs.getString("TenDN");
        String mk = rs.getString("MatKhau");
        String anh = rs.getString("Anh");
        String cv = rs.getString("CV");
        ds.add(new nguoidungbean(mand, hoten, diachi, sodt, email, tendn, mk, anh, cv));
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

  public nguoidungbean ktdn(String tendn, String pass) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<nguoidungbean> ds = new ArrayList<nguoidungbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from NguoiDung where TenDN=? and MatKhau=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, tendn);
      cmd.setString(2, pass);
      ResultSet rs = cmd.executeQuery();
      nguoidungbean nd = null;
      // b3: dua du lieu vao mang ds
      while (rs.next()) { // dang nhap thanh cong
        long mand = rs.getLong("MaND");
        String hoten = rs.getString("HoTen");
        String diachi = rs.getString("DiaChi");
        String sodt = rs.getString("SoDT");
        String email = rs.getString("Email");
        String anh = rs.getString("Anh");
        String cv = rs.getString("CV");
        nd = new nguoidungbean(mand, hoten, diachi, sodt, email, tendn, pass, anh, cv);
      }
      // b4: dong ket noi
      rs.close();
      kn.cn.close();
      return nd;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public ArrayList<nguoidungbean> getndapply(long mav) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<nguoidungbean> ds = new ArrayList<nguoidungbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql =
          "select n.*\r\n" + "from ViecLam as v\r\n" + "    join DangKy as d on v.MaV = d.MaV\r\n"
              + "    join NguoiDung as n on d.MaND = n.MaND\r\n" + "where v.MaV = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mav);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long mand = rs.getLong("MaND");
        String hoten = rs.getString("HoTen");
        String diachi = rs.getString("DiaChi");
        String sodt = rs.getString("SoDT");
        String email = rs.getString("Email");
        String tendn = rs.getString("TenDN");
        String mk = rs.getString("MatKhau");
        String anh = rs.getString("Anh");
        String cv = rs.getString("CV");
        ds.add(new nguoidungbean(mand, hoten, diachi, sodt, email, tendn, mk, anh, cv));
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

  public int ThemND(String tendn, String pass, String hoten, String diachi, String sodt,
      String email) {
    try {
      // Tao 1 mang luu all loai
      String anh = "user-img/nd3.png";
      ArrayList<nguoidungbean> ds = new ArrayList<nguoidungbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "\r\n"
          + "insert into NguoiDung(HoTen, DiaChi, SoDT, Email, TenDN, MatKhau, Anh) values (?,?,?,?,?,?,?)";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, hoten);
      cmd.setString(2, diachi);
      cmd.setString(3, sodt);
      cmd.setString(4, email);
      cmd.setString(5, tendn);
      cmd.setString(6, pass);
      cmd.setString(7, anh);
      ResultSet rs = cmd.executeQuery();


      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public int sua(long mand, String hoten, String diachi, String sodt, String email) {
    try {
      // Tao 1 mang luu all loai
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql =
          "update NguoiDung \r\n" + "set HoTen=?, DiaChi=?, SoDT=?, Email=?\r\n" + "where MaND=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);

      cmd.setString(1, hoten);
      cmd.setString(2, diachi);
      cmd.setString(3, sodt);
      cmd.setString(4, email);
      cmd.setLong(5, mand);

      // b3: dua du lieu vao mang ds
      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }
}
