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
import bean.hinhthucbean;
import bean.linhvucbean;
import bean.nguoidungbean;
import bean.nhatdbean;
import bean.vieclambean;
import bean.vieclamchitietbean;
import bo.hinhthucbo;
import bo.linhvucbo;
import bo.nhatdbo;
import bo.vieclambo;
import bo.vieclamchitietbo;

/**
 * Servlet implementation class vieclamController
 */
@WebServlet("/vieclamController")
public class vieclamController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public vieclamController() {
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

    String key = request.getParameter("search-input");

    linhvucbo lvbo = new linhvucbo();
    ArrayList<linhvucbean> dslv = lvbo.getlv();

    nhatdbo ntdbo = new nhatdbo();
    ArrayList<nhatdbean> dsntd = ntdbo.getntd();

    hinhthucbo htbo = new hinhthucbo();
    ArrayList<hinhthucbean> dsht = htbo.getht();

    vieclambo vlbo = new vieclambo();
    ArrayList<vieclambean> dsvl = vlbo.getviec();

    vieclamchitietbo vlctbo = new vieclamchitietbo();
    ArrayList<vieclamchitietbean> dsvlct = vlctbo.getviecct();

    nguoidungbean nd = (nguoidungbean) session.getAttribute("nd");


    if (nd == null) {
      response.sendRedirect("ktdn");
    } else {
      dsvlct = vlctbo.getviecdaapply(nd.getMand());
      if (key != null) {
        dsvlct = vlctbo.getviectk(vlctbo.removeAccent(key));
      }

      request.setAttribute("dsvlct", dsvlct);
      request.setAttribute("dsvl", dsvl);
      request.setAttribute("dslv", dslv);
      request.setAttribute("dsntd", dsntd);
      request.setAttribute("dsht", dsht);
      RequestDispatcher rd = request.getRequestDispatcher("vieclam.jsp");
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
