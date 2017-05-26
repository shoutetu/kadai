package seikimatu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddResult
 */
@WebServlet("/AddResultServlet")
public class AddResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddResultServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itemId = request.getParameter("item_id");
		String addCount = request.getParameter("quantity");
		Shopping dao = null;
		try {
				dao = new Shopping();
				int add = Integer.parseInt(addCount);
				dao.AdditemQuantity(add, itemId);
				RequestDispatcher rd = request.getRequestDispatcher("/addresult.jsp");
				rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
