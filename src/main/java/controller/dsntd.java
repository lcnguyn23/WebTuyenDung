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
import bean.nhatdbean;
import bo.nhatdbo;

/**
 * Servlet implementation class dsntd
 */
@WebServlet("/dsntd")
public class dsntd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public dsntd() {
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
    nhatdbo ntdbo = new nhatdbo();
    ArrayList<nhatdbean> dsntd = ntdbo.getntd();

    adminbean ad = (adminbean) session.getAttribute("ad");

    if (ad == null) {
      response.sendRedirect("ktdnadmin");
    } else {

      request.setAttribute("dsntd", dsntd);

      RequestDispatcher rd = request.getRequestDispatcher("danhsachnhatd.jsp");
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
