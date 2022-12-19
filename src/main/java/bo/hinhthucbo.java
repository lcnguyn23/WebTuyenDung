package bo;

import java.util.ArrayList;
import bean.hinhthucbean;
import dao.hinhthucdao;

public class hinhthucbo {

  ArrayList<hinhthucbean> ds;
  hinhthucdao htdao = new hinhthucdao();

  public ArrayList<hinhthucbean> getht() {
    ds = htdao.getht();
    return ds;
  }
}
