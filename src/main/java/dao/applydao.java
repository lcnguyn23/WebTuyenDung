package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import bean.applybean;
import bean.nguoidungbean;

public class applydao {

  public ArrayList<applybean> getapply() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<applybean> ds = new ArrayList<applybean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from DangKy";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long madk = rs.getLong("MaDK");
        long mand = rs.getLong("MaND");
        long mav = rs.getLong("MaV");
        Date ngaydk = rs.getDate("NgayDK");
        int duocnhan = rs.getInt("duocnhan");
        ds.add(new applybean(madk, mand, mav, ngaydk, duocnhan));
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

  public ArrayList<applybean> getapptheoviec(long mav) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<applybean> ds = new ArrayList<applybean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from DangKy where MaV=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mav);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long madk = rs.getLong("MaDK");
        long mand = rs.getLong("MaND");
        Date ngaydk = rs.getDate("NgayDK");
        int duocnhan = rs.getInt("duocnhan");
        ds.add(new applybean(madk, mand, mav, ngaydk, duocnhan));
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

  public int Themdk(long mand, long mav) {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "insert into DangKy(MaND, MaV, NgayDK, duocnhan) values(?,?,?,?)";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mand);
      cmd.setLong(2, mav);
      Date n = new Date();
      SimpleDateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
      String ngay = dd.format(n);
      Date ngaymua = dd.parse(ngay);
      cmd.setString(3, ngay);
      cmd.setInt(4, 0);
      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public applybean duocnhan(long mand, long mav) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<nguoidungbean> ds = new ArrayList<nguoidungbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "\r\n" + "select * from DangKy\r\n" + "where MaND=? and MaV=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mand);
      cmd.setLong(2, mav);
      ResultSet rs = cmd.executeQuery();
      applybean nd = null;
      // b3: dua du lieu vao mang ds
      while (rs.next()) { // dang nhap thanh cong
        long madk = rs.getLong("MaDK");
        Date ngaydk = rs.getDate("NgayDK");
        int duocnhan = rs.getInt("duocnhan");
        nd = new applybean(madk, mand, mav, ngaydk, duocnhan);
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

  public int Xoadk(long mand, long mav) {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "delete from DangKy where MaV=? and MaND=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mav);
      cmd.setLong(2, mand);
      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public int Xoadkmv(long mav) {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "delete from DangKy where MaV=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mav);
      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public int xacnhan(long mand, long mav) {
    try {
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      String sql = "\r\n" + "update DangKy\r\n" + "set duocnhan = 1\r\n" + "where MaND=? and MaV=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mand);
      cmd.setLong(2, mav);
      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }


  public static void main(String[] args) {
    // TODO Auto-generated method stub
    applydao hd = new applydao();


    hd.Themdk(2, 2);
  }
}
