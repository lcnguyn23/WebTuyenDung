package bo;

import java.util.ArrayList;
import bean.topctybean;
import dao.topctydao;

public class topctybo {

  ArrayList<topctybean> ds;
  topctydao topdao = new topctydao();

  public ArrayList<topctybean> gettopntd() {
    ds = topdao.gettopntd();
    return ds;
  }

}
