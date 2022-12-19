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
import bean.nguoidungbean;
import bo.nguoidungbo;

/**
 * Servlet implementation class dsnd
 */
@WebServlet("/dsnd")
public class dsnd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public dsnd() {
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
    nguoidungbo ndbo = new nguoidungbo();
    ArrayList<nguoidungbean> dsnd = ndbo.getnd();

    adminbean ad = (adminbean) session.getAttribute("ad");

    if (ad == null) {
      response.sendRedirect("ktdnadmin");
    } else {

      request.setAttribute("dsnd", dsnd);

      RequestDispatcher rd = request.getRequestDispatcher("danhsachnd.jsp");
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
