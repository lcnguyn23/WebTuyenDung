package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import bean.nhatdbean;
import bo.applybo;

/**
 * Servlet implementation class huyapplyntdController
 */
@WebServlet("/huyapplyntdController")
public class huyapplyntdController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public huyapplyntdController() {
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

    nhatdbean ntd = (nhatdbean) session.getAttribute("ntd");
    long mand = Long.parseLong(request.getParameter("mand"));
    long huymv = Long.parseLong(request.getParameter("huymv"));
    if (ntd == null) {
      response.sendRedirect("ktdnntd");
    } else {
      applybo abo = new applybo();
      abo.Xoadk(mand, huymv);
      response.sendRedirect("thongtintdController?mv=" + huymv);
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
