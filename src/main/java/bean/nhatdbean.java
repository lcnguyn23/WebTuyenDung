package bean;

public class nhatdbean {

  private long mantd;
  private String tenntd;
  private String tendn;
  private String mk;
  private String anh;

  public nhatdbean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public nhatdbean(long mantd, String tenntd, String tendn, String mk, String anh) {
    super();
    this.mantd = mantd;
    this.tenntd = tenntd;
    this.tendn = tendn;
    this.mk = mk;
    this.anh = anh;
  }

  public long getMantd() {
    return mantd;
  }

  public void setMantd(long mantd) {
    this.mantd = mantd;
  }

  public String getTenntd() {
    return tenntd;
  }

  public void setTenntd(String tenntd) {
    this.tenntd = tenntd;
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

  public String getAnh() {
    return anh;
  }

  public void setAnh(String anh) {
    this.anh = anh;
  }



}
