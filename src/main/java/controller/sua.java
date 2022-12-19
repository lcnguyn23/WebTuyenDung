package controller;

import java.io.IOException;
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
 * Servlet implementation class sua
 */
@WebServlet("/sua")
public class sua extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public sua() {
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

    nguoidungbean nd = (nguoidungbean) session.getAttribute("nd");


    long mnd = Long.parseLong(request.getParameter("mnd"));
    String ht = request.getParameter("ht");
    String dc = request.getParameter("dc");
    String dt = request.getParameter("dt");
    String em = request.getParameter("em");

    if (nd != null) {
      nguoidungbo ndbo = new nguoidungbo();
      ndbo.SuaND(mnd, ht, dc, dt, em);
      RequestDispatcher rd = request.getRequestDispatcher("userinfo.jsp");
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
