package seikimatu;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String serch = request.getParameter("serch");

		try {
			Shopping shopping = new Shopping();
			ArrayList<itemBean> ai = shopping.getitem();
			ServletContext context;
			RequestDispatcher rd;
			String btn = request.getParameter("btn");

			if (serch != null && serch.equals("検索")) {
				String price1 = request.getParameter("inputPrice1");
				System.out.println(price1);
				String price2 = request.getParameter("inputPrice2");
				System.out.println(price2);
				ShoppingDao dao = new ShoppingDao();
				ArrayList<itemBean> ab = dao.itemSerch(price1, price2);
				if (ab != null) {
					context = request.getServletContext();
					request.setAttribute("itemBeanList", ab);
					rd = context.getRequestDispatcher("/manager.jsp");
					rd.forward(request, response);
				}
			}
				else if (ai != null) {
				context = request.getServletContext();
				request.setAttribute("itemBeanList", ai);
				rd = context.getRequestDispatcher("/manager.jsp");
				rd.forward(request, response);
			} else if (btn.equals("追加")) {
				String id = request.getParameter("itemId");
				context = request.getServletContext();
				request.setAttribute("itemId", id);
				rd = context.getRequestDispatcher("/Add2ItemServlet");
				rd.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
