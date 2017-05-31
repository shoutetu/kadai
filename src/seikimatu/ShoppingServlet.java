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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String id = ((LoginUserBean) session.getAttribute("user_db")).getUserId();
		try {
				Shopping shopping = new Shopping();
				ArrayList<HistoryBean> ai = shopping.getHistory(id);
				if (ai != null) {
					ServletContext context = request.getServletContext();
					RequestDispatcher rd;
					session.setAttribute("buyHistory", ai);
					rd = context.getRequestDispatcher("/History.jsp");
					rd.forward(request, response);
				}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String serch = request.getParameter("serch");
		String sort = request.getParameter("sort");

		try {
			Shopping shopping = new Shopping();
			ArrayList<itemBean> ai = shopping.getitem();
			System.out.println(ai);
			String btn = request.getParameter("btn");
			ServletContext context;
			RequestDispatcher rd;
			System.out.println("ShoppingServlet doPost!!!");

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
					rd = context.getRequestDispatcher("/itemList.jsp");
					rd.forward(request, response);
				}
			}else if(sort != null && sort.equals("並び替え（昇順）")){
				ShoppingDao dao = new ShoppingDao();
				ArrayList<itemBean> alib = dao.sort();
				if(alib != null){
					context = request.getServletContext();
					request.setAttribute("itemBeanList", alib);
					rd = context.getRequestDispatcher("/itemList.jsp");
					rd.forward(request, response);
				}
			} else if (ai != null) {
				context = request.getServletContext();
				request.setAttribute("itemBeanList", ai);
				rd = context.getRequestDispatcher("/itemList.jsp");
				rd.forward(request, response);
			} else if (btn.equals("購入")) {
				String id = request.getParameter("itemId");
				context = request.getServletContext();
				request.setAttribute("itemId", id);
				rd = context.getRequestDispatcher("/BuyItemServlet");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "エラー");
		}
	}
}
