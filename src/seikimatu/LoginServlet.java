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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ServletContext context = request.getServletContext();
		RequestDispatcher rd;
		try {
			HttpSession session = request.getSession();
			session.removeAttribute("user_db");
			rd = context.getRequestDispatcher("/Logout.jsp");
			rd.forward(request, response);
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
		LoginUserBean bean;
		HttpSession session = request.getSession();
		ServletContext context;
		RequestDispatcher rd;
		Login lo = null;
		String login = null;
		String id = request.getParameter("userId");
		System.out.println("id:" + id);
		String password = request.getParameter("password");
		System.out.println("pass:" + password);
		String Tr = request.getParameter("tr");
		try {
			login = request.getParameter("btn");
			// 1-1 ログインチェック実施
			// 1-2 ログインチェック判定
			if (login != null && login.equals("ログイン")) {
				lo = new Login();
				bean = lo.LoginCheck(request, response);

				if (bean != null && bean.getUserId().equals("kanri") && bean.getPassword().equals("manager")) {
					context = request.getServletContext();
					session = request.getSession();
					session.setAttribute("user_db", bean);
					session.setAttribute("login_db", lo);
					rd = context.getRequestDispatcher("/ManagerManage.jsp");
					rd.forward(request, response);

				} else if (bean != null) {
					context = request.getServletContext();
					// セッションスコープの準備
					session = request.getSession();
					// セッションスコープからデータを取得
					// セッションスコープへデータを格納
					session.setAttribute("user_db", bean);
					session.setAttribute("login_db", lo);
					rd = context.getRequestDispatcher("/ShoppingServlet");
					rd.forward(request, response);

				} else if (bean == null) {
					context = request.getServletContext();
					rd = context.getRequestDispatcher("/LoginNG.jsp");
					rd.forward(request, response);

				}

			} else if (login != null && login.equals("新規登録")) {
				context = request.getServletContext();
				session.setAttribute("message1", "");
				rd = context.getRequestDispatcher("/Touroku.jsp");
				rd.forward(request, response);
			} else if (Tr != null && Tr.equals("登録")) {
				String new_id = request.getParameter("new_id");
				String new_pass = request.getParameter("new_pass");
				String new_name = request.getParameter("new_name");
				String age = request.getParameter("new_age");
				String new_address = request.getParameter("new_address");
				int new_age = Integer.parseInt(age);
				LoginDao ld = new LoginDao();
				bean = ld.usingCheck(new_id, new_pass, new_name);

				// IDが使用済みの場合
				if (new_id != null && bean.getUserId()==new_id) {
					session.setAttribute("message", "そのIDはすでに使用されています。");
					context = request.getServletContext();
					rd = context.getRequestDispatcher("/Touroku.jsp");
					rd.forward(request, response);
				}

				// 全部使われていなかったら
				else {
					ld.touroku(new_id, new_pass, new_name, new_age,new_address);
					request.setAttribute("new_id", new_id);
					request.setAttribute("new_pass", new_pass);
					request.setAttribute("new_name", new_name);
					request.setAttribute("new_age", new_age);
					request.setAttribute("new_address", new_address);
					context = request.getServletContext();
					rd = context.getRequestDispatcher("/TourokuOK.jsp");
					rd.forward(request, response);
				}

				}
		}catch (Exception e) {
			e.printStackTrace();

		}
}
}
