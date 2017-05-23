package seikimatu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;;

public class LoginDao {
	private Connection connection;

	public LoginDao() throws ClassNotFoundException,SQLException{
		String url ="jdbc:mysql://localhost:3306/java_test";
		String user ="root";
		String password ="aljep009";
		connection = DriverManager.getConnection(url,user,password);
	}
	public void close(){
		try{
			if(connection != null){
				connection.close();
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

public LoginUserBean selectuser(String id,String pass)throws SQLException {
	LoginUserBean LB =new LoginUserBean();
	PreparedStatement pstatement= null;
	try{
		String sql = "select * from user where id = ? and pass = ?";
			pstatement =connection.prepareStatement(sql);

			pstatement.setString(1, id);
			pstatement.setString(2,pass);
			ResultSet rs = null;
			rs = pstatement.executeQuery();
			while(rs.next()){
				LB.setUserId(rs.getString("id"));
				LB.setPassword(rs.getString("pass"));
				LB.setName(rs.getString("name"));
				System.out.print(LB);
			}
			rs.close();
	}finally{
		pstatement.close();
	}
	return LB;
}
public void touroku(String id,String pass,String name,int age)throws SQLException {
	PreparedStatement pstatement= null;
	try{
		String sql ="insert into user(id,pass,name,age) values(?,?,?,?)";
		pstatement = connection.prepareStatement(sql);

		pstatement.setString(1, id);
		pstatement.setString(2, pass);
		pstatement.setString(3, name);
		pstatement.setInt(4, age);
		pstatement.executeUpdate();


	}finally{
		pstatement.close();
	}

}
}
