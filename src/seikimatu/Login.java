package seikimatu;

import javax.servlet.http.HttpServletRequest;

public class Login {
	public LoginUserBean LoginCheck(HttpServletRequest request)throws Exception{
		LoginDao daotest = null;
		LoginUserBean empList = null;
		String id =request.getParameter("userId");
		String password = request.getParameter("password");
		try{
			if(id != null && password != null && !id.equals("") && !password.equals("")){
				daotest= new LoginDao();

				empList=  daotest.selectuser(id, password);
			}
		}finally{
			if(daotest != null){
				daotest.close();
				}
			}
		return empList;

	}


	}



