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
import bo.nhatdbo;

/**
 * Servlet implementation class ktdnntd
 */
@WebServlet("/ktdnntd")
public class ktdnntd extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ktdnntd() {
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
      nhatdbo ntdbo = new nhatdbo();
      nhatdbean ntd = ntdbo.ktdnntd(un, pass);
      if (ntd != null) {
        // Tao ra session
        HttpSession session = request.getSession();
        session.setAttribute("ntd", ntd);
        response.sendRedirect("tuyendungController");

      } else {
        // response.sendRedirect("dangnhap.jsp");
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
