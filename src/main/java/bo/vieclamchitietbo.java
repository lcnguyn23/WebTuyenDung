package bo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;
import bean.vieclamchitietbean;
import dao.vieclamchitietdao;

public class vieclamchitietbo {

  ArrayList<vieclamchitietbean> ds;
  vieclamchitietdao vlctdao = new vieclamchitietdao();

  public ArrayList<vieclamchitietbean> getviecct() {
    ds = vlctdao.getviecct();
    return ds;
  }

  public ArrayList<vieclamchitietbean> getviecdaapply(long mand) {
    ds = vlctdao.getviecdaapply(mand);
    return ds;
  }

  public ArrayList<vieclamchitietbean> getviecdaapply2(long mand) {
    ds = vlctdao.getviecdaapply2(mand);
    return ds;
  }

  public static String removeAccent(String s) {

    String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    return pattern.matcher(temp).replaceAll("");
  }


  public ArrayList<vieclamchitietbean> getviectk(String key) {
    String keyencode = removeAccent(key);
    ArrayList<vieclamchitietbean> tam = new ArrayList<vieclamchitietbean>();
    for (vieclamchitietbean vl : ds) {
      if (removeAccent(vl.getTenviec()).toLowerCase().contains(keyencode.toLowerCase())
          || removeAccent(vl.getMota()).toLowerCase().contains(keyencode.toLowerCase())
          || removeAccent(vl.getDiadiem()).toLowerCase().contains(keyencode.toLowerCase())
          || removeAccent(vl.getKynang()).toLowerCase().contains(keyencode.toLowerCase())
          || removeAccent(vl.getTenht()).toLowerCase().contains(keyencode.toLowerCase())
          || removeAccent(vl.getTenlv()).toLowerCase().contains(keyencode.toLowerCase())
          || removeAccent(vl.getTenntd()).toLowerCase().contains(keyencode.toLowerCase())
          || vl.getMaht().toLowerCase().contains(keyencode.toLowerCase())
          || vl.getMalv().toLowerCase().contains(keyencode.toLowerCase()))
        tam.add(vl);

    }
    return tam;
  }

  public static void main(String[] args) {
    vieclamchitietdao ds1 = new vieclamchitietdao();
    ArrayList<vieclamchitietbean> dsss = ds1.getviecct();
    String key = "Đà nẵng";
    String keyencode = removeAccent(key);
    for (vieclamchitietbean vl : dsss) {
      System.out
          .print(removeAccent(vl.getDiadiem()).toLowerCase().contains(keyencode.toLowerCase()));
    }
  }
}
