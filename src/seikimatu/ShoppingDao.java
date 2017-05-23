package seikimatu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShoppingDao {
	private Connection connection;

	public ShoppingDao() throws ClassNotFoundException,SQLException{
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

public ArrayList<itemBean> selectitem()throws SQLException {
	ArrayList<itemBean> AL = null;
	PreparedStatement pstatement = null;
	ResultSet rs = null;
	try{
		String sql = "select b.item_id, b.item_name ,b.price,a.quantity from stok a, item b where a.item_id = b.item_id";
			pstatement =connection.prepareStatement(sql);

			rs = pstatement.executeQuery();
			AL = new ArrayList<itemBean>();

			while(rs.next()){
				itemBean iB= new itemBean();
				iB.setItemid(rs.getString("item_id"));
				iB.setItemname(rs.getString("item_name"));
				iB.setItemprice(rs.getInt("price"));
				iB.setItemQuantity(rs.getInt("quantity"));
				AL.add(iB);
			}
			rs.close();
		}finally{
			pstatement.close();
		}
		return AL;
}
public itemBean selectitem(String item_id)throws SQLException{
	itemBean ib=null;
	PreparedStatement pstatement =null;
	ResultSet rs = null;
	try{
		String sql ="select item.item_id,item.item_name, item.price ,stok.quantity from stok , item  where stok.item_id = item.item_id and item.item_id = ?";
		pstatement =connection.prepareStatement(sql);
		pstatement.setString(1,item_id);
		rs = pstatement.executeQuery();

		if(rs.next()){
			ib=new itemBean();
			ib.setItemid(rs.getString("item.item_id"));
			ib.setItemname(rs.getString("item.item_name"));
			ib.setItemprice(rs.getInt("item.price"));
			ib.setItemQuantity(rs.getInt("stok.quantity"));
		}
		rs.close();
	}finally{
		pstatement.close();
	}
	return ib;
		}
public ArrayList<HistoryBean> getHistory(String id)throws SQLException{
	ArrayList<HistoryBean> AH =null;
	PreparedStatement pstatement =null;
	ResultSet rs =null;
	try{
		String sql ="select a.item_id, b.item_name, a.quantity from history a , item b where a.id = ? and a.item_id = b.item_id";
		pstatement =connection.prepareStatement(sql);
		pstatement.setString(1, id);
		rs = pstatement.executeQuery();
		AH = new ArrayList<HistoryBean>();

		if(rs.next()){
			HistoryBean iB=new HistoryBean();
			iB.setItemid(rs.getString("a.item_id"));
			iB.setItemName(rs.getString("b.item_name"));
			iB.setItemByQuantity(rs.getInt("a.quantity"));
			AH.add(iB);
		}
		rs.close();
	}finally{
		pstatement.close();
	}
	return AH;
		}
public void updateitem(String item_id,int buyCount)throws SQLException{
	PreparedStatement pstatement=null;

	try{
		String sql ="update stok set quantity = quantity - ? where item_id = ?";
		pstatement= connection.prepareStatement(sql);
		pstatement.setString(2, item_id);
		pstatement.setInt(1, buyCount);
		pstatement.executeUpdate();

}finally{
	pstatement.close();
}
}
public void updateHistory(String id,String item_id,int quantity)throws SQLException{
	PreparedStatement pstatement=null;

	try{
		String sql ="insert into history (id, item_id, quantity) values (?, ?, ?)";
		pstatement= connection.prepareStatement(sql);
		pstatement.setString(1, id);
		pstatement.setString(2, item_id);
		pstatement.setInt(3, quantity);
		pstatement.executeUpdate();

}finally{
	pstatement.close();
}
}
}