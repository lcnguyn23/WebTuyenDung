package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import bean.soapplybean;

public class soapplydao {

  public ArrayList<soapplybean> getcount() {
    try {
      // Tao 1 mang luu all loai
      ArrayList<soapplybean> ds = new ArrayList<soapplybean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select v.MaV, n.TenNTD, count(d.MaV) as SoApply\r\n" + "from DangKy as d\r\n"
          + "    right join ViecLam as v on d.MaV = v.MaV\r\n"
          + "    right join NhaTuyenDung as n on v.MaNTD = n.MaNTD\r\n"
          + "group by v.MaV, n.TenNTD";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      ResultSet rs = cmd.executeQuery();
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long mav = rs.getLong("MaV");
        long soa = rs.getLong("SoApply");
        String tenntd = rs.getString("TenNTD");
        ds.add(new soapplybean(mav, soa, tenntd));
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

  public soapplybean getso(long mav) {
    try {
      // Tao 1 mang luu all loai
      ArrayList<soapplybean> ds = new ArrayList<soapplybean>();
      // b1: ket noi vao csdl
      KetNoi kn = new KetNoi();
      kn.KetNoi();
      // b2: lay du lieu ve
      String sql = "select v.MaV, n.TenNTD, count(d.MaV) as SoApply\r\n" + "from DangKy as d\r\n"
          + "    right join ViecLam as v on d.MaV = v.MaV\r\n"
          + "    right join NhaTuyenDung as n on v.MaNTD = n.MaNTD\r\n" + "where v.MaV = ?\r\n"
          + "group by v.MaV, n.TenNTD";
      PreparedStatement cmd = kn.cn.prepareStatement(sql);
      cmd.setLong(1, mav);
      ResultSet rs = cmd.executeQuery();
      soapplybean so = null;
      // b3: dua du lieu vao mang ds
      while (rs.next()) {
        long soa = rs.getLong("SoApply");
        String tenntd = rs.getString("TenNTD");
        so = new soapplybean(mav, soa, tenntd);
      }
      // b4: dong ket noi
      rs.close();
      kn.cn.close();
      return so;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }



}
