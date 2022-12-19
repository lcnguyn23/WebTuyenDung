package bean;

import java.util.Date;

public class applybean {

  private long madk;
  private long mand;
  private long mav;
  private Date ngaydk;
  private int duocnhan;
  private long soapply;

  public applybean() {
    super();
    // TODO Auto-generated constructor stub
  }

  public applybean(long madk, long mand, long mav, Date ngaydk, int duocnhan) {
    super();
    this.madk = madk;
    this.mand = mand;
    this.mav = mav;
    this.ngaydk = ngaydk;
    this.duocnhan = duocnhan;
  }

  public long getMadk() {
    return madk;
  }

  public void setMadk(long madk) {
    this.madk = madk;
  }

  public long getMand() {
    return mand;
  }

  public void setMand(long mand) {
    this.mand = mand;
  }

  public long getMav() {
    return mav;
  }

  public void setMav(long mav) {
    this.mav = mav;
  }

  public Date getNgaydk() {
    return ngaydk;
  }

  public void setNgaydk(Date ngaydk) {
    this.ngaydk = ngaydk;
  }

  public int getDuocnhan() {
    return duocnhan;
  }

  public void setDuocnhan(int duocnhan) {
    this.duocnhan = duocnhan;
  }


}
