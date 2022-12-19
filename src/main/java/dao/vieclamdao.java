package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import bean.vieclambean;

public class vieclamdao {

  public ArrayList<vieclambean> getviec() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<vieclambean> ds = new ArrayList<vieclambean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from ViecLam";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long mav = rs.getLong("MaV");
        String tenv = rs.getString("TenV");
        String mota = rs.getString("MoTa");
        String kynang = rs.getString("KyNang");
        String diadiem = rs.getString("DiaDiem");
        Date ngaydang = rs.getDate("NgayDang");
        Date handk = rs.getDate("HanDK");
        long nstt = rs.getLong("NganSachTT");
        long nstd = rs.getLong("NganSachTD");
        String ht = rs.getString("MaHT");
        long ntd = rs.getLong("MaNTD");
        String kinhnghiem = rs.getString("KinhNghiem");
        String malv = rs.getString("MaLV");
        ds.add(new vieclambean(mav, tenv, mota, kynang, diadiem, ngaydang, handk, nstt, nstd, ht,
            ntd, kinhnghiem, malv));
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

  public int xoa(long mav) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<vieclambean> ds = new ArrayList<vieclambean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "delete from ViecLam where MaV = ?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mav);

      // b3: dua du lieu vao mang ds
      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public int sua(long mav, String tenv, String dd, long tt, long td, String sk, String kin,
      String mt, String handk, String maht, String malv) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<vieclambean> ds = new ArrayList<vieclambean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "update ViecLam\r\n"
          + "set TenV=?, MoTa=?, KyNang=?, DiaDiem=?, NganSachTT=?, NganSachTD=?, KinhNghiem=?, HanDK=?, MaHT=?, MaLV=?\r\n"
          + "where MaV=?";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, tenv);
      cmd.setString(2, mt);
      cmd.setString(3, sk);
      cmd.setString(4, dd);
      cmd.setLong(5, tt);
      cmd.setLong(6, td);
      cmd.setString(7, kin);
      cmd.setString(8, handk);
      cmd.setString(9, maht);
      cmd.setString(10, malv);
      cmd.setLong(11, mav);


      // b3: dua du lieu vao mang ds
      int kq = cmd.executeUpdate();
      kn.cn.close();
      return kq;
    } catch (Exception e) {
      e.printStackTrace();
      return 0;
    }
  }

  public int them(String tenv, String dd, long tt, long td, String sk, String kin, String mt,
      String handk, String maht, String malv, long mantd) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<vieclambean> ds = new ArrayList<vieclambean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql =
          "insert into ViecLam(TenV, DiaDiem, NganSachTT, NganSachTD, KyNang, KinhNghiem, MoTa, HanDK, MaHT, MaLV, MaNTD) values (?,?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setString(1, tenv);
      cmd.setString(2, dd);
      cmd.setLong(3, tt);
      cmd.setLong(4, td);
      cmd.setString(5, sk);
      cmd.setString(6, kin);
      cmd.setString(7, mt);
      cmd.setString(8, handk);
      cmd.setString(9, maht);
      cmd.setString(10, malv);
      cmd.setLong(11, mantd);

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
