package seikimatu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BuyItemServlet
 */
@WebServlet("/BuyItemServlet")
public class BuyItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String itemid ="";
		String buyCount = "";
		String buy;
		int totalPrice=0;
		try{

		Shopping shopping= new Shopping();
		itemid =request.getParameter("itemId");
		buyCount = request.getParameter("buyCount");
		System.out.print("itemid :"+ itemid);
		buy =request.getParameter("btn");

		if(buy.equals("購入")){
		itemBean ib = shopping.getitem(itemid);
		ShoppingDao dao = new ShoppingDao();
		int total =dao.totalPrice(itemid);
		int buyNum = Integer.parseInt(buyCount);
		totalPrice = buyNum * total;
		request.setAttribute("itemList", ib);
		request.setAttribute("buyCount", buyCount);
		request.setAttribute("totalPrice", totalPrice);
		RequestDispatcher rd=request.getRequestDispatcher("/confirm.jsp");
		rd.forward(request, response);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
