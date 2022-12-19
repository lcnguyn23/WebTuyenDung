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
import bean.topctybean;
import bean.vieclambean;
import bo.topctybo;
import bo.vieclambo;

/**
 * Servlet implementation class trangchuController
 */
@WebServlet("/trangchuController")
public class trangchuController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public trangchuController() {
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

    vieclambo vlbo = new vieclambo();
    ArrayList<vieclambean> dsviec = vlbo.getviec();

    topctybo topbo = new topctybo();
    ArrayList<topctybean> dstop = topbo.gettopntd();


    request.setAttribute("dsviec", dsviec);
    request.setAttribute("dstop", dstop);
    RequestDispatcher rd = request.getRequestDispatcher("trangchu.jsp");
    rd.forward(request, response);

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
