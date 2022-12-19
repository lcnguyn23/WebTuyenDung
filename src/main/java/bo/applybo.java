package bo;

import java.util.ArrayList;
import bean.applybean;
import dao.applydao;

public class applybo {

  ArrayList<applybean> ds;
  applydao adao = new applydao();

  public ArrayList<applybean> getapply() {
    ds = adao.getapply();
    return ds;
  }

  public ArrayList<applybean> getapptheoviec(long mav) {
    ds = adao.getapptheoviec(mav);
    return ds;
  }

  public int Themdk(long mand, long mav) {
    return adao.Themdk(mand, mav);
  }

  public int Xoadk(long mand, long mav) {
    return adao.Xoadk(mand, mav);
  }

  public int Xoadkmv(long mav) {
    return adao.Xoadkmv(mav);
  }

  public int xacnhan(long mand, long mav) {
    return adao.xacnhan(mand, mav);
  }

  public applybean duocnhan(long mand, long mav) {
    return adao.duocnhan(mand, mav);
  }
}
