package bo;

import java.util.ArrayList;
import bean.linhvucbean;
import dao.linhvucdao;

public class linhvucbo {

  ArrayList<linhvucbean> ds;
  linhvucdao lvdao = new linhvucdao();

  public ArrayList<linhvucbean> getlv() {
    ds = lvdao.getlv();
    return ds;
  }

}
