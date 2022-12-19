package bean;

public class nguoidungbean {

  private long mand;
  private String hoten;
  private String diachi;
  private String sodt;
  private String email;
  private String tendn;
  private String mk;
  private String anh;
  private String cv;

  public nguoidungbean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public nguoidungbean(long mand, String hoten, String diachi, String sodt, String email,
      String tendn, String mk, String anh, String cv) {
    super();
    this.mand = mand;
    this.hoten = hoten;
    this.diachi = diachi;
    this.sodt = sodt;
    this.email = email;
    this.tendn = tendn;
    this.mk = mk;
    this.anh = anh;
    this.cv = cv;
  }

  public long getMand() {
    return mand;
  }

  public void setMand(long mand) {
    this.mand = mand;
  }

  public String getHoten() {
    return hoten;
  }

  public void setHoten(String hoten) {
    this.hoten = hoten;
  }

  public String getDiachi() {
    return diachi;
  }

  public void setDiachi(String diachi) {
    this.diachi = diachi;
  }

  public String getSodt() {
    return sodt;
  }

  public void setSodt(String sodt) {
    this.sodt = sodt;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
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

  public String getCv() {
    return cv;
  }

  public void setCv(String cv) {
    this.cv = cv;
  }



}
