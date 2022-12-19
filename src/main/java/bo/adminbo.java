package bo;

import bean.adminbean;
import dao.admindao;

public class adminbo {

  admindao addao = new admindao();

  public adminbean ktdnadmin(String tendn, String pass) {
    return addao.ktdnadmin(tendn, pass);
  }

}
