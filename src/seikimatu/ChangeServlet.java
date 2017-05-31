package seikimatu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		String btn = request.getParameter("btn");
		String pass =request.getParameter("changePass");
		String name =request.getParameter("changeName");
		String age =request.getParameter("changeAge");
		String address =request.getParameter("changeAddress");
		String userId = request.getParameter("userId");
		LoginDao dao;
		ServletContext context;
		RequestDispatcher rd;
		try{
			if(btn != null && btn.equals("変更")){
				if(pass != null){
					dao = new LoginDao();
					dao.changePass(pass, userId);
					context=request.getServletContext();
					request.setAttribute("new", pass);
					rd =context.getRequestDispatcher("/changeResult.jsp");
					rd.forward(request, response);

				}else if(name != null){
					dao= new LoginDao();
					dao.changeName(name, userId);
					context=request.getServletContext();
					request.setAttribute("new", name);
					rd =context.getRequestDispatcher("/changeResult.jsp");
					rd.forward(request, response);

				}else if(age != null){
					int Age = Integer.parseInt(age);
					dao = new LoginDao();
					dao.changeAge(Age, userId);
					context=request.getServletContext();
					request.setAttribute("new", Age);
					rd =context.getRequestDispatcher("/changeResult.jsp");
					rd.forward(request, response);

				}else if(address != null){
					dao = new LoginDao();
					dao.changeAddress(address, userId);
					context=request.getServletContext();
					request.setAttribute("new", address);
					rd =context.getRequestDispatcher("/changeResult.jsp");
					rd.forward(request, response);
				}
			}

		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
