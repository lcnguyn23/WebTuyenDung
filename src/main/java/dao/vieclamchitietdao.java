package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import bean.vieclamchitietbean;

public class vieclamchitietdao {

  public ArrayList<vieclamchitietbean> getviecct() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<vieclamchitietbean> ds = new ArrayList<vieclamchitietbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from VJOBS";
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
        String kinhnghiem = rs.getString("KinhNghiem");
        String ht = rs.getString("TenHT");
        String lv = rs.getString("TenLV");
        String ntd = rs.getString("TenNTD");
        String anh = rs.getString("Anh");
        String malv = rs.getString("MaLV");
        long mantd = rs.getLong("MaNTD");
        String maht = rs.getString("MaHT");
        ds.add(new vieclamchitietbean(mav, tenv, mota, kynang, diadiem, ngaydang, handk, nstt, nstd,
            kinhnghiem, ht, lv, ntd, anh, malv, mantd, maht));
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

  public ArrayList<vieclamchitietbean> getviecdaapply(long mand) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<vieclamchitietbean> ds = new ArrayList<vieclamchitietbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select * from VJOBS as v\r\n"
          + "        full join (select * from DangKy where MaND = ?) d on v.MaV = d.MaV\r\n"
          + "where d.MaND <> ? or d.MaND is null\r\n" + "";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mand);
      cmd.setLong(2, mand);
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
        String kinhnghiem = rs.getString("KinhNghiem");
        String ht = rs.getString("TenHT");
        String lv = rs.getString("TenLV");
        String ntd = rs.getString("TenNTD");
        String anh = rs.getString("Anh");
        String malv = rs.getString("MaLV");
        long mantd = rs.getLong("MaNTD");
        String maht = rs.getString("MaHT");
        ds.add(new vieclamchitietbean(mav, tenv, mota, kynang, diadiem, ngaydang, handk, nstt, nstd,
            kinhnghiem, ht, lv, ntd, anh, malv, mantd, maht));
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

  public ArrayList<vieclamchitietbean> getviecdaapply2(long mand) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<vieclamchitietbean> ds = new ArrayList<vieclamchitietbean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "\r\n" + "select * \r\n" + "from VJOBS as v\r\n"
          + "    left join DangKy as d on v.MaV = d.MaV\r\n" + "where d.MaND = ? ";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mand);
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
        String kinhnghiem = rs.getString("KinhNghiem");
        String ht = rs.getString("TenHT");
        String lv = rs.getString("TenLV");
        String ntd = rs.getString("TenNTD");
        String anh = rs.getString("Anh");
        String malv = rs.getString("MaLV");
        long mantd = rs.getLong("MaNTD");
        String maht = rs.getString("MaHT");
        ds.add(new vieclamchitietbean(mav, tenv, mota, kynang, diadiem, ngaydang, handk, nstt, nstd,
            kinhnghiem, ht, lv, ntd, anh, malv, mantd, maht));
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
