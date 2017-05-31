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
 * Servlet implementation class ManageServlet
 */
@WebServlet("/ManageServlet")
public class ManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String delete =request.getParameter("btn");
		String userId= request.getParameter("userId");
		String userName = request.getParameter("userName");
		String change = request.getParameter("change");
		ServletContext context;
		LoginDao dao;
		RequestDispatcher rd;
		try{
		if(delete != null && delete.equals("削除")){
			ArrayList<LoginUserBean> lbean = new ArrayList<LoginUserBean>();
			dao = new LoginDao();
			dao.delete(userId);
			lbean=dao.userList();
			context=request.getServletContext();
			request.setAttribute("userList", lbean);
			request.setAttribute("message", userName + "さんを削除しました。");
			rd=request.getRequestDispatcher("/userList.jsp");
			rd.forward(request, response);

		}else if(change != null && change.equals("変更")){
			String[] checkers = request.getParameterValues("check");
			for(int i=0;i<checkers.length;i++){
			if(checkers[i].equals("password")){
				request.setAttribute("userName", userName);
				request.setAttribute("userId", userId);
				context=request.getServletContext();
				rd=request.getRequestDispatcher("/changePass.jsp");
				rd.forward(request, response);
			}
			else if(checkers[i].equals("名前")){
				request.setAttribute("userName", userName);
				request.setAttribute("userId", userId);
				context=request.getServletContext();
				rd=request.getRequestDispatcher("/changeName.jsp");
				rd.forward(request, response);
			}
			else if(checkers[i].equals("年齢")){
				request.setAttribute("userName", userName);
				request.setAttribute("userId", userId);
				context=request.getServletContext();
				rd=request.getRequestDispatcher("/changeAge.jsp");
				rd.forward(request, response);
			}
			else if(checkers[i].equals("住所")){
				request.setAttribute("userName", userName);
				request.setAttribute("userId", userId);
				context=request.getServletContext();
				rd=request.getRequestDispatcher("/changeAddress.jsp");
				rd.forward(request, response);
			}
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
		String userList = request.getParameter("userList");
		String itemList = request.getParameter("itemList");
		String search = request.getParameter("search");
		String reset = request.getParameter("reset");
		ServletContext context;
		RequestDispatcher rd;
		try{
			if(search != null && search.equals("検索")){
				String inputAge1 = request.getParameter("inputAge1");
				String inputAge2 = request.getParameter("inputAge2");
				int age1 = Integer.parseInt(inputAge1);
				int age2 = Integer.parseInt(inputAge2);
				LoginDao dao= new LoginDao();
				ArrayList<LoginUserBean> bean =dao.userSearch(age1, age2);
				if(bean != null){
					context = request.getServletContext();
					request.setAttribute("userList", bean);
					rd =context.getRequestDispatcher("/userList.jsp");
					rd.forward(request, response);
				}
			}
			if(userList != null && userList.equals("ユーザー一覧")||reset != null && reset.equals("元に戻す")){
				ArrayList<LoginUserBean> lbean = new ArrayList<LoginUserBean>();
				LoginDao dao = new LoginDao();
				lbean= dao.userList();
				if(lbean != null){
					context= request.getServletContext();
					request.setAttribute("userList", lbean);
					rd=request.getRequestDispatcher("/userList.jsp");
					rd.forward(request, response);
				}
			}else if(itemList != null && itemList.equals("商品一覧")){
				Shopping shopping = new Shopping();
				ArrayList<itemBean> ai = shopping.getitem();
				if(ai != null){
				context = request.getServletContext();
				request.setAttribute("itemBeanList", ai);
				rd = context.getRequestDispatcher("/manager.jsp");
				rd.forward(request, response);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
