package bo;

import java.util.ArrayList;
import bean.nguoidungbean;
import dao.nguoidungdao;

public class nguoidungbo {

  ArrayList<nguoidungbean> ds;
  nguoidungdao nddao = new nguoidungdao();

  public ArrayList<nguoidungbean> getnd() {
    ds = nddao.getnd();
    return ds;
  }

  public nguoidungbean ktdn(String tendn, String pass) {
    return nddao.ktdn(tendn, pass);
  }

  public int Kiemtra(String tendn, String pass) {
    int check = 0;
    for (nguoidungbean nd : ds)
      if (nd.getTendn().equals(tendn) && nd.getMk().equals(pass))
        check = 1;
    return check;
  }

  public ArrayList<nguoidungbean> getndapply(long mav) {
    ds = nddao.getndapply(mav);
    return ds;
  }

  public int ThemND(String tendn, String pass, String hoten, String diachi, String sodt,
      String email) {
    return nddao.ThemND(tendn, pass, hoten, diachi, sodt, email);
  }

  public int SuaND(long mand, String hoten, String diachi, String sodt, String email) {
    return nddao.sua(mand, hoten, diachi, sodt, email);
  }
}
