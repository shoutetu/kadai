package seikimatu;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ResultServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = ((LoginUserBean)request.getSession().getAttribute("user_db")).getUserId();
		String itemId = request.getParameter("item_id");
		int buyCount= Integer.parseInt(request.getParameter("quantity"));
		ShoppingDao dao = null;
		try {
			dao = new ShoppingDao();
			dao.updateitem(itemId, buyCount);
			dao.updateHistory(userId, itemId, buyCount);

	}catch(SQLException | ClassNotFoundException e){
		e.printStackTrace();
	}finally{
		if(dao != null){
			dao.close();
		}
	RequestDispatcher rd=request.getRequestDispatcher("/result.jsp");
	rd.forward(request, response);
}
}
}
