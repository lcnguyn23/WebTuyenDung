package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.adminbean;
import bo.adminbo;

/**
 * Servlet implementation class ktdnadmin
 */
@WebServlet("/ktdnadmin")
public class ktdnadmin extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ktdnadmin() {
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
    String un = request.getParameter("txtun");
    String pass = request.getParameter("txtpass");

    if (un != null && pass != null) {
      adminbo adbo = new adminbo();
      adminbean ad = adbo.ktdnadmin(un, pass);
      if (ad != null) {
        // Tao ra session
        HttpSession session = request.getSession();
        session.setAttribute("ad", ad);
        response.sendRedirect("adminController");

      } else {
        // response.sendRedirect("dangnhap.jsp");
        RequestDispatcher rd = request.getRequestDispatcher("dangnhapadmin.jsp");
        rd.forward(request, response);
      }
    } else {
      RequestDispatcher rd = request.getRequestDispatcher("dangnhapadmin.jsp");
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
