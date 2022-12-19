package bean;

public class soapplybean {



  private long mav;

  private long soapply;

  private String tenntd;

  public soapplybean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public soapplybean(long mav, long soapply, String tenntd) {
    super();
    this.mav = mav;
    this.soapply = soapply;
    this.tenntd = tenntd;
  }

  public long getMav() {
    return mav;
  }

  public void setMav(long mav) {
    this.mav = mav;
  }

  public long getSoapply() {
    return soapply;
  }

  public void setSoapply(long soapply) {
    this.soapply = soapply;
  }

  public String getTenntd() {
    return tenntd;
  }

  public void setTenntd(String tenntd) {
    this.tenntd = tenntd;
  }



}
