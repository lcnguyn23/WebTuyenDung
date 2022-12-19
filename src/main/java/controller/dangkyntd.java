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
import bo.nhatdbo;

/**
 * Servlet implementation class dangkyntd
 */
@WebServlet("/dangkyntd")
public class dangkyntd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public dangkyntd() {
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

    String un = request.getParameter("txtun");
    String mk = request.getParameter("txtpass");
    String name = request.getParameter("txtname");


    if (un != null && mk != null) {
      nhatdbo ntdbo = new nhatdbo();
      ArrayList<nhatdbean> dskh = ntdbo.getntd();
      if (ntdbo.Kiemtra(un, mk) == 0) {
        ntdbo.ThemNTD(un, mk, name);
        response.sendRedirect("dangnhapntd.jsp");
      } else {
        RequestDispatcher rd = request.getRequestDispatcher("dangnhapntd.jsp");
        rd.forward(request, response);
      }
    } else {
      RequestDispatcher rd = request.getRequestDispatcher("dangnhapntd.jsp");
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
