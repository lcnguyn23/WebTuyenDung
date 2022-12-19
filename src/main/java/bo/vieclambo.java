package bo;

import java.util.ArrayList;
import bean.vieclambean;
import dao.vieclamdao;

public class vieclambo {

  ArrayList<vieclambean> ds;
  vieclamdao vldao = new vieclamdao();

  public ArrayList<vieclambean> getviec() {
    ds = vldao.getviec();
    return ds;
  }

  public int xoa(long mav) {
    return vldao.xoa(mav);
  }

  public vieclambean Tim(long mav, long mantd) {
    vieclambean vl = new vieclambean();
    ArrayList<vieclambean> ds1 = vldao.getviec();
    for (vieclambean v : ds1) {
      if (v.getMav() == mav && v.getMantd() == mantd) {
        vl = v;
      }
    }
    return vl;
  }

  public int sua(long mav, String tenv, String dd, long tt, long td, String sk, String kin,
      String mt, String handk, String maht, String malv) {
    return vldao.sua(mav, tenv, dd, tt, td, sk, kin, mt, handk, maht, malv);
  }

  public int them(String tenv, String dd, long tt, long td, String sk, String kin, String mt,
      String handk, String maht, String malv, long mantd) {
    return vldao.them(tenv, dd, tt, td, sk, kin, mt, handk, maht, malv, mantd);
  }
}
