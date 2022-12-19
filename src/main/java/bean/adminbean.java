package bean;

public class adminbean {

  private String tendn;
  private String mk;
  private int quyen;

  public adminbean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public adminbean(String tendn, String mk, int quyen) {
    super();
    this.tendn = tendn;
    this.mk = mk;
    this.quyen = quyen;
  }

  public String getTendn() {
    return tendn;
  }

  public void setTendn(String tendn) {
    this.tendn = tendn;
  }

  public String getMk() {
    return mk;
  }

  public void setMk(String mk) {
    this.mk = mk;
  }

  public int getQuyen() {
    return quyen;
  }

  public void setQuyen(int quyen) {
    this.quyen = quyen;
  }



}
