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
import bean.nguoidungbean;
import bo.nguoidungbo;

/**
 * Servlet implementation class dangky
 */
@WebServlet("/dangky")
public class dangky extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public dangky() {
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
    String ht = request.getParameter("txtht");
    String dc = request.getParameter("txtdc");
    String dt = request.getParameter("txtdt");
    String em = request.getParameter("txtem");

    if (un != null && mk != null && ht != null && dc != null) {
      nguoidungbo ndbo = new nguoidungbo();
      ArrayList<nguoidungbean> dskh = ndbo.getnd();
      if (ndbo.Kiemtra(un, mk) == 0) {
        ndbo.ThemND(un, mk, ht, dc, dt, em);
        response.sendRedirect("dangnhap.jsp");
      } else {
        RequestDispatcher rd = request.getRequestDispatcher("dangnhap.jsp");
        rd.forward(request, response);
      }
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
