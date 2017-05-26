package seikimatu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login {
	public LoginUserBean LoginCheck(HttpServletRequest request, HttpServletResponse response)throws Exception{
		LoginDao daotest = null;
		LoginUserBean empList = null;
		RequestDispatcher rd;
		ServletContext context =request.getServletContext();
		String id =request.getParameter("userId");
		String password = request.getParameter("password");
		try{
			if(id != null && password != null && !id.equals("") && !password.equals("")){
				daotest= new LoginDao();
				empList=  daotest.selectuser(id, password);
				if(empList.getUserId() == null || empList.getPassword()==null){
					rd=context.getRequestDispatcher("/LoginNG.jsp");
					rd.forward(request, response);


				}
			}
		}finally{
			if(daotest != null){
				daotest.close();
				}
			}
		return empList;

	}


	}



