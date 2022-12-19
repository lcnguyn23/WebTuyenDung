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
import bean.nhatdbean;
import bean.soapplybean;
import bean.vieclamchitietbean;
import bo.soapplybo;
import bo.vieclambo;
import bo.vieclamchitietbo;

/**
 * Servlet implementation class xoatd
 */
@WebServlet("/xoatd")
public class xoatd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public xoatd() {
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

    // String key = request.getParameter("search-input");
    String xoamv = request.getParameter("xoamv");
    long mv = Long.parseLong(xoamv);
    nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");

    vieclambo vlbo = new vieclambo();


    vieclamchitietbo vlctbo = new vieclamchitietbo();
    ArrayList<vieclamchitietbean> dsvlct = vlctbo.getviecct();

    soapplybo soabo = new soapplybo();
    ArrayList<soapplybean> dsapply = soabo.getsoa();
    soapplybean so = new soapplybean();

    if (ntd == null) {
      response.sendRedirect("ktdnntd");
    } else {
      String key = ntd.getTenntd();
      if (xoamv != null) {
        vlbo.xoa(mv);
      }

      dsvlct = vlctbo.getviectk(vlctbo.removeAccent(key));
      request.setAttribute("dsapply", dsapply);
      request.setAttribute("dsvlct", dsvlct);
      RequestDispatcher rd = request.getRequestDispatcher("quanlytuyendung.jsp");
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
