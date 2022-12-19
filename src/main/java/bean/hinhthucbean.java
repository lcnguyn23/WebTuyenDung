package bean;

public class hinhthucbean {

  private String maht;
  private String tenht;
  private String ht;

  public hinhthucbean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public hinhthucbean(String maht, String tenht, String ht) {
    super();
    this.maht = maht;
    this.tenht = tenht;
    this.ht = ht;
  }

  public String getMaht() {
    return maht;
  }

  public void setMaht(String maht) {
    this.maht = maht;
  }

  public String getTenht() {
    return tenht;
  }

  public void setTenht(String tenht) {
    this.tenht = tenht;
  }

  public String getHt() {
    return ht;
  }

  public void setHt(String ht) {
    this.ht = ht;
  }



}
