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
import bean.adminbean;
import bean.hinhthucbean;
import bean.linhvucbean;
import bean.nhatdbean;
import bean.vieclambean;
import bean.vieclamchitietbean;
import bo.applybo;
import bo.hinhthucbo;
import bo.linhvucbo;
import bo.nhatdbo;
import bo.vieclambo;
import bo.vieclamchitietbo;

/**
 * Servlet implementation class xoatin
 */
@WebServlet("/xoatin")
public class xoatin extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public xoatin() {
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

    String key = request.getParameter("search-input");

    String xoa = request.getParameter("xoa");

    linhvucbo lvbo = new linhvucbo();
    ArrayList<linhvucbean> dslv = lvbo.getlv();

    nhatdbo ntdbo = new nhatdbo();
    ArrayList<nhatdbean> dsntd = ntdbo.getntd();

    hinhthucbo htbo = new hinhthucbo();
    ArrayList<hinhthucbean> dsht = htbo.getht();

    vieclambo vlbo = new vieclambo();
    ArrayList<vieclambean> dsvl = vlbo.getviec();

    vieclamchitietbo vlctbo = new vieclamchitietbo();
    ArrayList<vieclamchitietbean> dsvlct = vlctbo.getviecct();

    adminbean ad = (adminbean) session.getAttribute("ad");

    applybo abo = new applybo();


    if (ad == null) {
      response.sendRedirect("ktdnadmin");
    } else {

      if (xoa != null) {
        long max = Long.parseLong(xoa);
        abo.Xoadkmv(max);
        vlbo.xoa(max);

      }

      request.setAttribute("dsvlct", dsvlct);
      request.setAttribute("dsvl", dsvl);
      request.setAttribute("dslv", dslv);
      request.setAttribute("dsntd", dsntd);
      request.setAttribute("dsht", dsht);
      RequestDispatcher rd = request.getRequestDispatcher("adminController");
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
