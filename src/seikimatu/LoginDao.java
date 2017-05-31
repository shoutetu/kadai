package seikimatu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;;

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
public LoginUserBean usingCheck(String id,String pass,String name)throws SQLException{
	PreparedStatement pstatement = null;
	LoginUserBean bean = new LoginUserBean();
	try{
		String sql="select id,pass,name from user where id =? and pass=? and name= ?";
		pstatement = connection.prepareStatement(sql);

		pstatement.setString(1, id);
		pstatement.setString(2, pass);
		pstatement.setString(3, name);
		ResultSet rs = null;
		rs = pstatement.executeQuery();
		while(rs.next()){
			bean.setUserId(rs.getString("id"));
			bean.setPassword(rs.getString("pass"));
			bean.setName(rs.getString("name"));
		}
		rs.close();
	}finally{
		pstatement.close();
	}
	return bean;
}
public void touroku(String id,String pass,String name,int age,String address)throws SQLException {
	PreparedStatement pstatement= null;
	try{
		String sql ="insert into user(id,pass,name,age,address) values(?,?,?,?,?)";
		pstatement = connection.prepareStatement(sql);

		pstatement.setString(1, id);
		pstatement.setString(2, pass);
		pstatement.setString(3, name);
		pstatement.setInt(4, age);
		pstatement.setString(5, address);
		pstatement.executeUpdate();
	}catch(SQLException e){
		return;

	}finally{
		pstatement.close();
	}
}
public ArrayList<LoginUserBean> userList()throws SQLException{
	PreparedStatement pstatement= null;
	ArrayList<LoginUserBean> bean = new ArrayList<LoginUserBean>();
	ResultSet rs ;
	try{
		String sql="select * from user";
		pstatement = connection.prepareStatement(sql);
		rs =pstatement.executeQuery();

		while(rs.next()){
			LoginUserBean lbean = new LoginUserBean();
			lbean.setUserId(rs.getString("id"));
			lbean.setPassword(rs.getString("pass"));
			lbean.setName(rs.getString("name"));
			lbean.setAge(rs.getInt("age"));
			lbean.setAddress(rs.getString("address"));
			bean.add(lbean);
		}
		rs.close();
	}finally{
		pstatement.close();
	}
	return bean;
}
public void delete(String userId)throws SQLException{
	PreparedStatement pstatement = null;
	try{
		String sql="delete from user where id = ?";
		pstatement = connection.prepareStatement(sql);
		pstatement.setString(1, userId);
		pstatement.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		pstatement.close();
	}
}
public ArrayList<LoginUserBean> userSearch(int age1,int age2)throws SQLException{
	PreparedStatement pstatement = null;
	ArrayList<LoginUserBean> bean = new ArrayList<LoginUserBean>();
	ResultSet rs ;
	try{
		String sql="select * from user where age between ? and ?";
		pstatement = connection.prepareStatement(sql);
		pstatement.setInt(1,age1);
		pstatement.setInt(2, age2);
		rs= pstatement.executeQuery();

		while(rs.next()){
			LoginUserBean lbean = new LoginUserBean();
			lbean.setUserId(rs.getString("id"));
			lbean.setPassword(rs.getString("pass"));
			lbean.setName(rs.getString("name"));
			lbean.setAge(rs.getInt("age"));
			lbean.setAddress(rs.getString("address"));
			bean.add(lbean);
		}
		rs.close();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		pstatement.close();
	}
	return bean;
}
public void changePass(String pass,String id)throws SQLException{
	PreparedStatement pstatement= null;
	try{
		String sql="update user set pass=? where id=?";
		pstatement = connection.prepareStatement(sql);
		pstatement.setString(1, pass);
		pstatement.setString(2, id);
		pstatement.executeUpdate();
	}finally{
		pstatement.close();
	}
}
public void changeName(String name,String id)throws SQLException{
	PreparedStatement pstatement= null;
	try{
		String sql="update user set name=? where id=?";
		pstatement = connection.prepareStatement(sql);
		pstatement.setString(1, name);
		pstatement.setString(2, id);
		pstatement.executeUpdate();
	}finally{
		pstatement.close();
	}
}
public void changeAge(int age,String id)throws SQLException{
	PreparedStatement pstatement= null;
	try{
		String sql="update user set age=? where id=?";
		pstatement = connection.prepareStatement(sql);
		pstatement.setInt(1, age);
		pstatement.setString(2, id);
		pstatement.executeUpdate();
	}finally{
		pstatement.close();
	}
}
public void changeAddress(String address,String id)throws SQLException{
	PreparedStatement pstatement= null;
	try{
		String sql="update user set address=? where id=?";
		pstatement = connection.prepareStatement(sql);
		pstatement.setString(1, address);
		pstatement.setString(2, id);
		pstatement.executeUpdate();
	}finally{
		pstatement.close();
	}
}

}
