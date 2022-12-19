package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.nhatdbean;
import bo.vieclambo;

/**
 * Servlet implementation class dangtd
 */
@WebServlet("/dangtd")
public class dangtd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public dangtd() {
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
    request.setCharacterEncoding("UTF-8");

    String tenv = request.getParameter("tenv");
    String dd = request.getParameter("dd");
    long tt = Long.parseLong(request.getParameter("nstt"));
    long td = Long.parseLong(request.getParameter("nstd"));
    String sk = request.getParameter("skill");
    String kn = request.getParameter("kn");
    String mt = request.getParameter("mota");
    String handk = request.getParameter("handk");
    String ht = request.getParameter("ht");
    String lv = request.getParameter("lv");

    nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");
    if (ntd != null) {
      vieclambo vlbo = new vieclambo();
      vlbo.them(tenv, dd, tt, td, sk, kn, mt, handk, ht, lv, ntd.getMantd());
      RequestDispatcher rd = request.getRequestDispatcher("tuyendungController");
      rd.forward(request, response);
    } else {
      RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
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
