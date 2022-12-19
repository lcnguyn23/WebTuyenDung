package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.hinhthucbean;
import bean.linhvucbean;
import bean.nguoidungbean;
import bean.nhatdbean;
import bean.soapplybean;
import bean.vieclambean;
import bean.vieclamchitietbean;
import bo.applybo;
import bo.hinhthucbo;
import bo.linhvucbo;
import bo.nguoidungbo;
import bo.soapplybo;
import bo.vieclambo;
import bo.vieclamchitietbo;

/**
 * Servlet implementation class xacnhan
 */
@WebServlet("/xacnhan")
public class xacnhan extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public xacnhan() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    HttpSession session = request.getSession();

    String mv = request.getParameter("mv");
    String mnd = request.getParameter("mnd");
    nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");

    vieclambo vlbo = new vieclambo();
    vieclambean vl = new vieclambean();

    linhvucbo lvbo = new linhvucbo();
    ArrayList<linhvucbean> dslv = lvbo.getlv();

    hinhthucbo htbo = new hinhthucbo();
    ArrayList<hinhthucbean> dsht = htbo.getht();

    vieclamchitietbo vlctbo = new vieclamchitietbo();
    ArrayList<vieclamchitietbean> dsvlct = vlctbo.getviecct();

    soapplybo soabo = new soapplybo();
    ArrayList<soapplybean> dsapply = soabo.getsoa();
    soapplybean so = new soapplybean();

    nguoidungbo ndbo = new nguoidungbo();

    applybo abo = new applybo();


    if (ntd == null) {
      response.sendRedirect("ktdnntd");
    } else {
      long mav = Long.parseLong(mv);
      long mand = Long.parseLong(mnd);
      abo.xacnhan(mand, mav);
      ArrayList<nguoidungbean> dsndapply = ndbo.getndapply(vl.getMav());

      request.setAttribute("xn", "xacnhan");
      request.setAttribute("viec", vl);
      request.setAttribute("dsapply", dsapply);
      request.setAttribute("dsvlct", dsvlct);
      request.setAttribute("dslv", dslv);
      request.setAttribute("dsht", dsht);
      request.setAttribute("dsndapply", dsndapply);
      RequestDispatcher rd = request.getRequestDispatcher("thongtintdController");
      rd.forward(request, response);
    }
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
