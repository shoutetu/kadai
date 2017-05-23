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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//購入履歴
		Shopping shopping;
		HttpSession session=request.getSession();
		ServletContext context=request.getServletContext();
		String id = request.getParameter("userId");
		String rireki = request.getParameter("submit");
		try{

		RequestDispatcher rd ;
		if(session.getAttribute("login_db").equals("Login")){
		if(rireki.equals("購入履歴")){
			shopping = new Shopping();
			ArrayList<HistoryBean>  hbean = shopping.getHistory(id);

				session.setAttribute("history", hbean);
				rd= context.getRequestDispatcher("/History.jsp");
				rd.forward(request, response);
			}
		}

	}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		try{
		Shopping shopping =new Shopping();
		ArrayList<itemBean> ai=shopping.getitem();
		String btn =request.getParameter("btn");

		ServletContext  context;
		RequestDispatcher rd;


		if(ai != null){
			 context = request.getServletContext();
			//セッションスコープの準備
			//セッションスコープからデータを取得
			//セッションスコープへデータを格納
			request.setAttribute ("itemBeanList",ai);
			//1-2-2
			rd= context.getRequestDispatcher("/itemList.jsp");
			rd.forward(request, response);
if(btn.equals("購入")){
	String id =request.getParameter("itemId");
				context= request.getServletContext();
				request.setAttribute("itemId", id);
				rd =context.getRequestDispatcher("/BuyItemServlet");
				rd.forward(request, response);
			}
		}

	}catch(Exception e){
		request.setAttribute("message", "エラー");

		}
	}
}
