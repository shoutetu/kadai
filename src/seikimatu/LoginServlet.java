package seikimatu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		LoginUserBean bean =null;
		HttpSession session = request.getSession();
		ServletContext context;
		RequestDispatcher rd;
		Login lo =null;
		String login = null;
		String id=request.getParameter("userId");
		System.out.println("id:" + id);
		String password=request.getParameter("password");
		System.out.println("pass:" + password);
		String Tr = request.getParameter("tr");
		try{
			login =request.getParameter("btn");
			//1-1 ログインチェック実施
			//1-2 ログインチェック判定
			if(login != null && login.equals("ログイン")){
				lo = new Login();
				bean =lo.LoginCheck(request);

			if(bean != null){
				 context = request.getServletContext();
				//セッションスコープの準備
				 session=request.getSession();
				//セッションスコープからデータを取得
				//セッションスコープへデータを格納
				session.setAttribute ("user_db",bean);
				session.setAttribute("login_db", lo);
			 rd =context.getRequestDispatcher("/ShoppingServlet");
			rd.forward(request, response);
			}
			}
			if(login != null && login.equals("新規登録")){
					 context=request.getServletContext();
					rd= context.getRequestDispatcher("/Touroku.jsp");
					rd.forward(request, response);
			}
			if(Tr != null && Tr.equals("登録")){
				String new_id = request.getParameter("new_id");
				String new_pass = request.getParameter("new_pass");
				String new_name = request.getParameter("new_name");
				String age =request.getParameter("new_age");
				int new_age=Integer.parseInt(age);
				LoginDao ld= new LoginDao();
				ld.touroku(new_id, new_pass, new_name, new_age);

					context= request.getServletContext();
					session= request.getSession();
					session.setAttribute("user_db",new_id);
					rd=context.getRequestDispatcher("/tourokuOK.jsp");
					rd.forward(request, response);
				}

		}catch(Exception e){
				e.printStackTrace();
			}

	}
}




