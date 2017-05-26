package seikimatu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add2Item
 */
@WebServlet("/Add2ItemServlet")
public class Add2ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add2ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String itemid = request.getParameter("itemId");
		String addCount = request.getParameter("addCount");
		String add =request.getParameter("btn");

		try{
		Shopping shopping= new Shopping();
		int AddCount= Integer.parseInt(addCount);

		if(add.equals("追加")){
		itemBean ib = shopping.getitem(itemid);
		itemBean bean= shopping.AdditemQuantity(AddCount,itemid);
		request.setAttribute("itemList", ib);
		request.setAttribute("addCount", addCount);
		request.setAttribute("add", bean);
		RequestDispatcher rd=request.getRequestDispatcher("/addConfirm.jsp");
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
		doGet(request,response);
		}

}
