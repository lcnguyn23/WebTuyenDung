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
import bean.nhatdbean;
import bean.soapplybean;
import bean.vieclambean;
import bean.vieclamchitietbean;
import bo.hinhthucbo;
import bo.linhvucbo;
import bo.soapplybo;
import bo.vieclambo;
import bo.vieclamchitietbo;

/**
 * Servlet implementation class updatetd
 */
@WebServlet("/updatetd")
public class updatetd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public updatetd() {
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
    String mv = request.getParameter("mv");

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

    if (ntd == null) {
      response.sendRedirect("ktdnntd");
    } else {
      long mav = Long.parseLong(mv);
      String key = ntd.getTenntd();
      long mantd = ntd.getMantd();
      vl = vlbo.Tim(mav, mantd);
      dsvlct = vlctbo.getviectk(mv);
      request.setAttribute("viec", vl);
      request.setAttribute("dsapply", dsapply);
      request.setAttribute("dsvlct", dsvlct);
      request.setAttribute("dslv", dslv);
      request.setAttribute("dsht", dsht);
      RequestDispatcher rd = request.getRequestDispatcher("updatetd.jsp");
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
