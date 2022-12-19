package bo;

import java.util.ArrayList;
import bean.soapplybean;
import dao.soapplydao;

public class soapplybo {

  ArrayList<soapplybean> ds;
  soapplydao sadao = new soapplydao();

  public ArrayList<soapplybean> getsoa() {
    ds = sadao.getcount();
    return ds;
  }

  public soapplybean getso(long mav) {
    return sadao.getso(mav);
  }

}
