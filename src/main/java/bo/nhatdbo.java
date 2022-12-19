package bo;

import java.util.ArrayList;
import bean.nhatdbean;
import dao.nhatddao;

public class nhatdbo {

  ArrayList<nhatdbean> ds;
  nhatddao ntddao = new nhatddao();

  public ArrayList<nhatdbean> getntd() {
    ds = ntddao.getntd();
    return ds;
  }

  public int Kiemtra(String tendn, String pass) {
    int check = 0;
    for (nhatdbean ntd : ds)
      if (ntd.getTendn().equals(tendn) && ntd.getMk().equals(pass))
        check = 1;
    return check;
  }

  public nhatdbean ktdnntd(String tendn, String pass) {
    return ntddao.ktdnntd(tendn, pass);
  }

  public int ThemNTD(String tendn, String pass, String ten) {
    return ntddao.ThemNTD(tendn, pass, ten);
  }
}


